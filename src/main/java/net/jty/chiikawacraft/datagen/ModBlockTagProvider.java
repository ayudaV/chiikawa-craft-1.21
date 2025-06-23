package net.jty.chiikawacraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jty.chiikawacraft.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

/**
 * AI Generated Documentation
 * A data provider class used for generating and assigning block tags for custom blocks
 * in the ChiikawaCraft mod. This class extends Fabric's `FabricTagProvider.BlockTagProvider`
 * to define specific block classifications for custom blocks based on their tool requirements
 * and mining properties.
 *
 * This class is primarily used during data generation to ensure that blocks are associated
 * with the correct logical tags, enabling proper tool interactions and in-game mechanics.
 *
 * Features:
 * - Associates custom block types to pre-defined block tags such as `PICKAXE_MINEABLE`
 *   and `NEEDS_IRON_TOOL`, ensuring that blocks respond correctly to tool-based interactions.
 *
 * Constructor:
 * - ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture):
 *   Initializes the provider with the required data output and registry lookup.
 *
 * Overridden Method:
 * - configure(RegistryWrapper.WrapperLookup wrapperLookup): Maps custom blocks to appropriate
 *   tags during data generation by using the `getOrCreateTagBuilder` method.
 *
 * Usage:
 * This provider is automatically invoked by the Fabric Data Generator framework during data generation
 * workflows, ensuring that block tag configurations are written to the output files and utilized in-game.
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LIVING_GEM_BLOCK)
                .add(ModBlocks.LIVING_GEM_ORE)
                .add(ModBlocks.LIVING_GEM_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LIVING_GEM_DEEPSLATE_ORE);
    }
}
