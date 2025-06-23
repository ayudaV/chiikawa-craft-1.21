package net.jty.chiikawacraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup LIVING_GEM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChiikawaCraft.MOD_ID, "living_gem_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LIVING_GEM))
                    .displayName(Text.translatable("itemgroup.chiikawacraft.living_gem_items"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.LIVING_GEM);
                        entries.add(ModItems.RAW_LIVING_GEM);
                        entries.add(ModBlocks.LIVING_GEM_BLOCK);
                        entries.add(ModBlocks.LIVING_GEM_ORE);
                        entries.add(ModBlocks.LIVING_GEM_DEEPSLATE_ORE);
                        entries.add(ModItems.IRON_YOROI_HELMET);
                        entries.add(ModItems.GOLD_YOROI_HELMET);

                    }))
                    .build());

    public static final ItemGroup CHIIKAWACRAFT_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChiikawaCraft.MOD_ID, "chiikawacraft_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHIIKAWA_SPAWN_EGG))
                    .displayName(Text.translatable("itemgroup.chiikawacraft.chiikawacraft_items"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.CHIIKAWA_SPAWN_EGG);
                        entries.add(ModItems.HACHIWARE_SPAWN_EGG);
                        entries.add(ModItems.USAGI_SPAWN_EGG);
                        entries.add(ModItems.YOROI_SPAWN_EGG);
                        entries.add(ModItems.PANCAKE);
                        entries.add(ModItems.FLOUR);
                        entries.add(ModItems.BASKET);
                        entries.add(ModItems.CHIIKAWA_BASKET);
                        entries.add(ModItems.HACHIWARE_BASKET);
                        entries.add(ModItems.USAGI_BASKET);
                    }))
                    .build());

    public static void registerItemGroups() {
        ChiikawaCraft.LOGGER.info("Registering Item Groups for " + ChiikawaCraft.MOD_ID);
    }
}
