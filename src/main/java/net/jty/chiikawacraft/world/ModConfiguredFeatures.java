package net.jty.chiikawacraft.world;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.registry.tag.BlockTags;

import java.util.List;

/**
 * AI Generated Documentation
 * The {@code ModConfiguredFeatures} class is responsible for defining and registering
 * custom configured features used in the ChiikawaCraft mod. Configured features are
 * specific feature instances with defined parameters or configurations for use in
 * world generation.
 *
 * Key functionalities of this class:
 *
 * - Provides registry keys for custom features to ensure uniqueness and proper identification.
 * - Sets up configurations for ore generation features, such as the placement and size of custom ores.
 * - Manages the registration of configured features into the game using the provided context.
 *
 * The primary focus of this class is to support the implementation of world generation
 * for the custom "Living Gem" ore. It defines:
 *
 * - Replacement rules for the blocks where the custom ore can generate (e.g., stone or deepslate).
 * - Registration of the configured feature with its associated feature type, targets, and other parameters.
 *
 * This class is typically used in conjunction with placement modifiers (defined in other classes)
 * to control both the placement and frequency of custom feature generation in the game world.
 */
public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIVING_GEM_ORE_KEY = registerKey("living_gem_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldLivingGemOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.LIVING_GEM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.LIVING_GEM_DEEPSLATE_ORE.getDefaultState()));

        register(context, LIVING_GEM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldLivingGemOres, 6));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ChiikawaCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}