package net.jty.chiikawacraft.item.custom;

import com.google.common.collect.ImmutableMap;
import net.jty.chiikawacraft.damage_type.ModDamageTypes;
import net.jty.chiikawacraft.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

/**
 * The ModArmorItem class is an extension of the ArmorItem class, designed to provide custom behavior
 * for certain armor materials in a game. This class applies specific status effects to players
 * who wear a full set of armor made from designated custom materials. The effects, duration, and
 * amplifier levels vary based on the armor's material type. Additionally, it checks for specific configurations
 * of armor and can apply corresponding secondary effects or properties.
 *
 * Features:
 * - Maps specific armor materials to associated status effects.
 * - Ensures that players wearing a full set of custom armor receive matching effects.
 * - Utilizes a secondary material mapping system for armor validation.
 * - Periodically evaluates inventory to apply appropriate effects.
 *
 * Constructor:
 * - ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings):
 *   Initializes the ModArmorItem with the specified material, type, and settings.
 *
 * Overrides:
 * - inventoryTick:
 *   Called every game tick that the item is in the player's inventory. If the player is wearing
 *   a complete set of custom armor matching the material map, this method applies the corresponding
 *   status effects specified in the MATERIAL_TO_EFFECT_MAP.
 *
 * Private methods:
 * - evaluateArmorEffects(PlayerEntity player):
 *   Iterates through the MATERIAL_TO_EFFECT_MAP and applies the appropriate status effects
 *   to the player if they are wearing the correct armor.
 *
 * - addStatusEffectForMaterial(PlayerEntity player, RegistryEntry<ArmorMaterial> mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect):
 *   Adds status effects from the specified armor material's effect list to the player, ensuring
 *   no duplicate effects are applied.
 *
 * - hasFullSuitOfArmorOn(PlayerEntity player):
 *   Checks if the player is wearing a full set of armor by verifying that all armor item slots
 *   (boots, leggings, chestplate, helmet) are occupied.
 *
 * - hasCorrectArmorOn(RegistryEntry<ArmorMaterial> material, PlayerEntity player):
 *   Validates if the player is wearing armor made from the specified material type and corresponding
 *   secondary material types.
 *
 * Static constants:
 * - MATERIAL_TO_EFFECT_MAP:
 *   Defines the mapping of custom armor materials to their associated status effects.
 *
 * - SECUNDARY_MATERIAL:
 *   Maps custom armor materials to secondary materials required for validation during armor checks.
 */
public class ModArmorItem extends ArmorItem {
    private static final Map<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.IRON_YOROI_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.BLINDNESS, 400, 2, false, false),
                                    new StatusEffectInstance(StatusEffects.WITHER, 400, 2, false, false)))
                    .put(ModArmorMaterials.GOLD_YOROI_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.BLINDNESS, 400, 2, false, false),
                                    new StatusEffectInstance(StatusEffects.WITHER, 400, 2, false, false)))
                    .build();
    private static final Map<RegistryEntry<ArmorMaterial>, RegistryEntry<ArmorMaterial>> SECUNDARY_MATERIAL =
            (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>, RegistryEntry<ArmorMaterial>>())
                    .put(ModArmorMaterials.IRON_YOROI_ARMOR_MATERIAL, ArmorMaterials.IRON)
                    .put(ModArmorMaterials.GOLD_YOROI_ARMOR_MATERIAL, ArmorMaterials.GOLD)
                    .build();

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                    //player.damage(ModDamageTypes.of(world, ModDamageTypes.YOROI_DAMAGE_TYPE), 1.0f);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);
                ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());
                //player.damage(new DamageSource(DamageTypes.MAGIC), 1);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, RegistryEntry<ArmorMaterial> mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(!hasPlayerEffect) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(RegistryEntry<ArmorMaterial> material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == SECUNDARY_MATERIAL.get(material) &&
                leggings.getMaterial() == SECUNDARY_MATERIAL.get(material) && boots.getMaterial() == SECUNDARY_MATERIAL.get(material);
    }
}