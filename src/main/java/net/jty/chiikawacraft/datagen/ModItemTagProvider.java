package net.jty.chiikawacraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jty.chiikawacraft.item.ModItems;
import net.jty.chiikawacraft.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

/**
 * AI Generated Documentation
 * ModItemTagProvider is a custom implementation of the FabricTagProvider.ItemTagProvider
 * used to define and configure item tags for modded items in a Minecraft mod.
 *
 * This class is responsible for assigning custom items to specific item tags
 * to enable grouping and categorization in various gameplay contexts, such as crafting,
 * loot tables, and item lists in creative inventory tabs.
 *
 * Features:
 * - Extends the FabricTagProvider.ItemTagProvider to leverage its functionality for item tag management.
 * - Assigns modded items to pre-defined or custom tags to enable integration with game logic.
 * - Configures tags such as ItemTags.TRIMMABLE_ARMOR with specific modded items.
 *
 * Constructor:
 * - Accepts a FabricDataOutput object for controlling the output location of the generated tag data.
 * - Takes a CompletableFuture of type RegistryWrapper.WrapperLookup for asynchronous loading of tag configuration data.
 *
 * Core Methods:
 * - configure(RegistryWrapper.WrapperLookup wrapperLookup):
 *   Overrides the method to define the specific configuration of item tags, adding custom mod items to desired tags.
 */
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.IRON_YOROI_HELMET)
                .add(ModItems.GOLD_YOROI_HELMET);

    }
}
