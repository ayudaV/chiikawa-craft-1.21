package net.jty.chiikawacraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jty.chiikawacraft.block.ModBlocks;
import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

/**
 * A custom model provider class that extends the FabricModelProvider to handle
 * the generation of block state models and item models for the ChiikawaCraft mod.
 *
 * This class is responsible for defining and registering the visual presentation
 * of blocks and items in the game, ensuring that the models are correctly bound
 * to their respective resources.
 *
 * Features:
 * - Generates simple cube-all models for blocks.
 * - Associates item models with appropriate templates, including custom spawn eggs and armor items.
 *
 * Constructor:
 * - ModModelProvider(FabricDataOutput output): Initializes the model provider with the required data output.
 *
 * Overridden Methods:
 * - generateBlockStateModels: Registers block models using cube-all templates for specific blocks.
 * - generateItemModels: Registers item models using pre-defined templates or custom configurations.
 */
public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIVING_GEM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIVING_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIVING_GEM_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LIVING_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_LIVING_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANCAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BASKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHIIKAWA_BASKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.HACHIWARE_BASKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.USAGI_BASKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHIIKAWA_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.HACHIWARE_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.USAGI_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.YOROI_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IRON_YOROI_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GOLD_YOROI_HELMET));
    }
}
