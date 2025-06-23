package net.jty.chiikawacraft.world;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

/**
 * The {@code ModPlacedFeatures} class is responsible for registering and managing
 * custom placed features used in the ChiikawaCraft mod. This includes defining
 * how and where specific features (e.g., ores) are placed in the game world.
 *
 * Key functionalities of the class:
 *
 * - Registers keys for placed features to track and reference them within the mod.
 * - Implements methods for configuring and registering placed features using
 *   modifiers such as count and height range.
 * - Links placed features with their corresponding configured features, ensuring
 *   the placement follows the defined rules and modifiers.
 *
 * Features defined in this class are integrated into the world generation process
 * and determine how custom additions, such as the "Living Gem Ore", spawn in the
 * game world.
 */
public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> LIVING_GEM_ORE_PLACED_KEY = registerKey("living_gem_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, LIVING_GEM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIVING_GEM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60), YOffset.fixed(15))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ChiikawaCraft.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}