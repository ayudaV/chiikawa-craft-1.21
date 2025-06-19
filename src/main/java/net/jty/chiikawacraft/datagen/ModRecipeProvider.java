package net.jty.chiikawacraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.block.ModBlocks;
import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> LIVING_GEM_SMELTABLES = List.of(ModItems.RAW_LIVING_GEM, ModBlocks.LIVING_GEM_ORE, ModBlocks.LIVING_GEM_DEEPSLATE_ORE);

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.LIVING_GEM, ModItems.RAW_LIVING_GEM);
        offerSmelting(exporter, LIVING_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.LIVING_GEM, 0.25f, 200, "living_gem");
        offerBlasting(exporter, LIVING_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.LIVING_GEM, 0.25f, 100, "living_gem");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.LIVING_GEM, RecipeCategory.DECORATIONS, ModBlocks.LIVING_GEM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LIVING_GEM_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_LIVING_GEM)
                .criterion(hasItem(ModItems.RAW_LIVING_GEM), conditionsFromItem(ModItems.RAW_LIVING_GEM))
                .offerTo(exporter, Identifier.of(ChiikawaCraft.MOD_ID, "living_gem_block_from_raw_living_gem"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_YOROI_HELMET)
                .pattern("III")
                .pattern("ILI")
                .pattern("   ")
                .input('L', ModItems.LIVING_GEM)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.LIVING_GEM), conditionsFromItem(ModItems.LIVING_GEM))
                .offerTo(exporter, Identifier.of(ChiikawaCraft.MOD_ID, "iron_yoroi_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLD_YOROI_HELMET)
                .pattern("GGG")
                .pattern("GLG")
                .pattern("   ")
                .input('L', ModItems.LIVING_GEM)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(ModItems.LIVING_GEM), conditionsFromItem(ModItems.LIVING_GEM))
                .offerTo(exporter, Identifier.of(ChiikawaCraft.MOD_ID, "gold_yoroi_helmet"));
     }
}
