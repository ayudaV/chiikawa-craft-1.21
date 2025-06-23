package net.jty.chiikawacraft.item;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * A utility class for defining and managing custom armor materials in the ChiikawaCraft mod.
 *
 * This class provides methods and predefined constants for registering and handling custom
 * armor materials, allowing for unique properties, textures, and statistics to be associated
 * with specific armor types. The armor materials are utilized in custom armor items defined
 * elsewhere in the mod.
 *
 * Features:
 * - Defines constants for custom armor materials, such as IRON_YOROI_ARMOR_MATERIAL and
 *   GOLD_YOROI_ARMOR_MATERIAL, with specific properties like durability, sound, and crafting ingredients.
 * - Enables mapping of armor types (boots, leggings, chestplate, helmet, body) to their respective defense points.
 * - Supports custom layer configuration for armor textures in-game.
 * - Provides a static method for registering armor materials to the game's registries.
 *
 * Methods:
 * - registerArmorMaterial: Registers a custom armor material to the game's armor material registry.
 */
public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> IRON_YOROI_ARMOR_MATERIAL = registerArmorMaterial("iron_yoroi",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.LIVING_GEM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ChiikawaCraft.MOD_ID, "iron_yoroi"))), 0,0));

    public static final RegistryEntry<ArmorMaterial> GOLD_YOROI_ARMOR_MATERIAL = registerArmorMaterial("gold_yoroi",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> Ingredient.ofItems(ModItems.LIVING_GEM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ChiikawaCraft.MOD_ID, "gold_yoroi"))), 0,0));



    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(ChiikawaCraft.MOD_ID, name), material.get());
    }
}