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

/**
 * ModRecipeProvider is a custom recipe provider that extends FabricRecipeProvider
 * to define and register crafting, smelting, blasting, and stonecutting recipes in
 * the ChiikawaCraft mod. This class is responsible for handling the generation of
 * recipe data for the mod's custom items and blocks.
 *
 * Responsibilities:
 * - Register recipes for custom items and blocks, including but not limited
 *   to smelting, blasting, stonecutting, and custom-shaped crafting recipes.
 * - Create reversible compacting recipes for block-to-item and item-to-block transformations.
 * - Define unique recipes for armor, food, and other mod-specific items.
 *
 * Methods:
 * - ModRecipeProvider(FabricDataOutput, CompletableFuture<RegistryWrapper.WrapperLookup>):
 *   The constructor initializes the recipe provider with the required output and registry lookups.
 * - generate(RecipeExporter): Overridden method responsible for defining and exporting all
 *   custom recipes.
 */
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_YOROI_HELMET)
                .pattern("III")
                .pattern("ILI")
                .pattern("   ")
                .input('L', ModItems.LIVING_GEM)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.LIVING_GEM), conditionsFromItem(ModItems.IRON_YOROI_HELMET))
                .offerTo(exporter, Identifier.of(ChiikawaCraft.MOD_ID, "iron_yoroi_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLD_YOROI_HELMET)
                .pattern("GGG")
                .pattern("GLG")
                .pattern("   ")
                .input('L', ModItems.LIVING_GEM)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(ModItems.LIVING_GEM), conditionsFromItem(ModItems.GOLD_YOROI_HELMET))
                .offerTo(exporter, Identifier.of(ChiikawaCraft.MOD_ID, "gold_yoroi_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PANCAKE)
                .pattern("EF ")
                .pattern("H  ")
                .pattern("   ")
                .input('F', ModItems.FLOUR)
                .input('E', Items.EGG)
                .input('H', Items.HONEY_BOTTLE)
                .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.PANCAKE))
                .offerTo(exporter, Identifier.of(ChiikawaCraft.MOD_ID, "pancake"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FLOUR)
                .pattern("W  ")
                .pattern("   ")
                .pattern("   ")
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(ModItems.FLOUR))
                .offerTo(exporter, Identifier.of(ChiikawaCraft.MOD_ID, "flour"));
    }
}
