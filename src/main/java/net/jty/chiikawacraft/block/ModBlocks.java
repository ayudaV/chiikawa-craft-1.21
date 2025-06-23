package net.jty.chiikawacraft.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jty.chiikawacraft.ChiikawaCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

/**
 * AI Generated Documentation
 * The ModBlocks class is responsible for defining and registering custom blocks
 * used within the ChiikawaCraft mod. This class encapsulates the block instances,
 * their associated block items, and the utility methods required for registration
 * into the corresponding registries (e.g., Blocks and Items).
 *
 * Features:
 * - Defines all mod-specific block instances as static final fields.
 * - Provides methods to register blocks and their block items to the appropriate registries.
 * - Includes functionality to log the registration process for debugging purposes.
 *
 * Block Instances:
 * - LIVING_GEM_BLOCK: A decorative block with amethyst-like properties.
 * - LIVING_GEM_ORE: A mineable ore block that drops experience on mining.
 * - LIVING_GEM_DEEPSLATE_ORE: A deepslate variant of the living gem ore with increased strength.
 *
 * Key Methods:
 * - registerBlock: Simplifies the process of registering a block and its corresponding item.
 * - registerBlockItem: Handles the registration of an item form of a block.
 * - registerModBlocks: Logs the registration process and ensures all blocks are registered during mod initialization.
 */
public class ModBlocks {

    public static final Block LIVING_GEM_BLOCK = registerBlock("living_gem_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block LIVING_GEM_ORE = registerBlock("living_gem_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block LIVING_GEM_DEEPSLATE_ORE = registerBlock("living_gem_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ChiikawaCraft.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ChiikawaCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ChiikawaCraft.LOGGER.info("Registering Mod Blocks for " + ChiikawaCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(LIVING_GEM_BLOCK);
            entries.add(LIVING_GEM_ORE);

        });
    }
}
