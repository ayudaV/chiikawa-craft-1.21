package net.jty.chiikawacraft.item;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.item.custom.ModArmorItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.jty.chiikawacraft.item.ModArmorMaterials;
public class ModItems {
    public static final Item LIVING_GEM = registerItem("living_gem", new Item(new Item.Settings()));
    public static final Item RAW_LIVING_GEM = registerItem("raw_living_gem", new Item(new Item.Settings()));
    public static final Item PANCAKE = registerItem("pancake", new Item(new Item.Settings().food(ModFoodComponents.PANCAKE)));
    public static final Item FLOUR = registerItem("flour", new Item(new Item.Settings()));
    public static final Item BASKET =registerItem("basket", new Item(new Item.Settings().maxCount(16)));

    public static final Item CHIIKAWA_BASKET =registerItem("chiikawa_basket", new EntityBucketItem(ModEntities.CHIIKAWA, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_AXOLOTL, new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT)));


    public static final Item CHIIKAWA_SPAWN_EGG = registerItem("chiikawa_spawn_egg",
            new SpawnEggItem(ModEntities.CHIIKAWA, 0xfbf9f7, 0xf3c7cc, new Item.Settings()));

    public static final Item HACHIWARE_SPAWN_EGG = registerItem("hachiware_spawn_egg",
            new SpawnEggItem(ModEntities.HACHIWARE, 0xfbf9f7, 0x79acc4, new Item.Settings()));

    public static final Item USAGI_SPAWN_EGG = registerItem("usagi_spawn_egg",
            new SpawnEggItem(ModEntities.USAGI, 0xfbf3cc, 0xffc2c9, new Item.Settings()));

    public static final Item YOROI_SPAWN_EGG = registerItem("yoroi_spawn_egg",
            new SpawnEggItem(ModEntities.YOROI, 0x4a4a4a, 0xa6a6a6, new Item.Settings()));


    public static final Item IRON_YOROI_HELMET = registerItem("iron_yoroi_helmet",
            new ModArmorItem(ModArmorMaterials.IRON_YOROI_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item GOLD_YOROI_HELMET = registerItem("gold_yoroi_helmet",
            new ModArmorItem(ModArmorMaterials.GOLD_YOROI_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ChiikawaCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ChiikawaCraft.LOGGER.info("Registering Mod Items for " + ChiikawaCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(CHIIKAWA_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(HACHIWARE_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(USAGI_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(YOROI_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(FLOUR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(PANCAKE);
        });

    }
}
