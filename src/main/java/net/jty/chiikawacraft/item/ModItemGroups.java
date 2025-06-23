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

/**
 * AI Generated Documentation
 * The {@code ModItemGroups} class is responsible for registering custom item groups for the
 * ChiikawaCraft mod. These item groups allow better categorization and organization of
 * mod-related items within the game, providing a dedicated section in the creative inventory
 * for players to access mod-specific items and blocks.
 *
 * This class defines and registers two item groups:
 * <ul>
 * - {@code LIVING_GEM_ITEMS_GROUP}: Contains items and blocks related to living gems, such as ores,
 *   blocks, and helmets.
 * - {@code CHIIKAWACRAFT_ITEMS_GROUP}: Includes other mod-specific items like spawn eggs,
 *   consumables, and custom baskets.
 *
 * Each item group is initialized with:
 * - A custom group identifier using the mod's namespace.
 * - An icon representing the group, typically a related item from the mod.
 * - A localized display name for user-friendly naming in the game's interface.
 * - Predefined entries, which list the items and blocks that belong to the group, using
 *   a lambda to add them dynamically at runtime.
 *
 * Responsibilities of this class:
 * - Ensure the proper registration of all item groups into the Minecraft item registry.
 * - Log the item group registration process for debugging and tracking purposes.
 *
 * The {@link #registerItemGroups()} method must be called during the mod initialization phase
 * to add the item groups to the game successfully.
 */
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
