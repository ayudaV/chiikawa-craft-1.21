package net.jty.chiikawacraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jty.chiikawacraft.block.ModBlocks;
import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

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
