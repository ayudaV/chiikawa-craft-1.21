package net.jty.chiikawacraft.world;

import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

/**
 * AI Generated Documentation
 * The {@code ModOrePlacement} class provides utility methods for creating and managing
 * placement modifiers that define how ore features are distributed in the game world.
 *
 * This class offers methods for configuring placement modifiers using parameters such
 * as count, rarity, and height. These modifiers are essential for customizing the
 * appearance and frequency of specific world features, such as ores, within the
 * world generation process.
 *
 * Key functionalities of the class:
 *
 * - Combines multiple placement modifiers like count, height, square, and biome
 *   placement into a single list for easier configuration.
 * - Supports placement modifiers based on count or rarity to control the distribution
 *   frequency of features.
 * - Works in conjunction with other world generation structures to ensure compatibility
 *   and seamless integration of custom features.
 *
 * This class is commonly used in tandem with configured features and placed features
 * to define customized feature placements. It plays a vital role in ensuring
 * world-generation rules for custom ores or other features are applied consistently.
 */
public class ModOrePlacement {
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}