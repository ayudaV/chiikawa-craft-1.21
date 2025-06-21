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