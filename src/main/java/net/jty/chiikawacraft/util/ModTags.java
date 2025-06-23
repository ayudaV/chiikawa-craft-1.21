package net.jty.chiikawacraft.util;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * The ModTags class defines and organizes custom tags used within the mod.
 * Tags allow grouping of similar elements, such as blocks, for easier reference
 * and management within the game or during data generation.
 *
 * This class specifically contains nested static classes to categorize
 * tags based on their types. The Blocks nested class manages block-related tags
 * that can be used within the mod for grouping specific kinds of blocks.
 */
public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CHIIKAWA_CITY_BLOCKS = createTag("chiikawa_city_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ChiikawaCraft.MOD_ID, name));
        }
    }
}