package net.jty.chiikawacraft.item;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.item.custom.ModArmorItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.jty.chiikawacraft.item.ModArmorMaterials;
public class ModItems {
    public static final Item LIVING_GEM = registerItem("living_gem", new Item(new Item.Settings()));
    public static final Item RAW_LIVING_GEM = registerItem("raw_living_gem", new Item(new Item.Settings()));

    public static final Item CHIIKAWA_SPAWN_EGG = registerItem("chiikawa_spawn_egg",
            new SpawnEggItem(ModEntities.CHIIKAWA, 0xffffff, 0xffd9f5, new Item.Settings()));


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
    }
}
