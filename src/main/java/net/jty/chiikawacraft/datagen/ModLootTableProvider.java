package net.jty.chiikawacraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jty.chiikawacraft.block.ModBlocks;
import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * ModLootTableProvider is a custom loot table provider designed for generating loot
 * tables for blocks in the ChiikawaCraft mod.
 *
 * This class extends the FabricBlockLootTableProvider, utilizing it to define custom
 * drop rules for various blocks within the mod, such as ores and their unique drop items.
 *
 * Constructor:
 * - Accepts a FabricDataOutput instance to handle generated data output and a
 *   CompletableFuture for accessing the registry lookup, which provides block and item
 *   references for loot table definitions.
 *
 * Methods:
 * - generate: Overrides the generate method from FabricBlockLootTableProvider. This method
 *   defines the loot tables generation for specific blocks registered in the mod.
 *   - Adds standard block drops for certain blocks.
 *   - Adds ore drop rules, specifying custom item drops (e.g., raw gem items)
 *     when mining ores.
 */
public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LIVING_GEM_BLOCK);
        addDrop(ModBlocks.LIVING_GEM_ORE, oreDrops(ModBlocks.LIVING_GEM_ORE, ModItems.RAW_LIVING_GEM));
        addDrop(ModBlocks.LIVING_GEM_DEEPSLATE_ORE, oreDrops(ModBlocks.LIVING_GEM_DEEPSLATE_ORE, ModItems.RAW_LIVING_GEM));

    }
}
