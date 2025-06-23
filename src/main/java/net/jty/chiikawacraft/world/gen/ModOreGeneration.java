package net.jty.chiikawacraft.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jty.chiikawacraft.world.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

/**
 * AI Generated Documentation
 * The ModOreGeneration class is responsible for integrating custom ore generation
 * into the modded Minecraft world. This process ensures that specific ores defined
 * within the mod are added to the overworld during the world generation phase.
 *
 * Primary Function:
 * - Registers and adds a custom ore feature to the game's biome generation system.
 *
 * Ores Generated:
 * - The class integrates the "Living Gem Ore" feature into the underground ore
 *   generation step, ensuring its placement within the overworld biomes.
 *
 * Key Method:
 * - generateOres: Adds the custom ore feature to Minecraft's biome modification
 *   system, associating it with a specific generation step and ensuring its
 *   placement rules are adhered to during world generation.
 *
 * Usage:
 * - This class is invoked by the ModWorldGeneration class during the mod's world
 *   generation initialization phase.
 */
public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.LIVING_GEM_ORE_PLACED_KEY);
    }
}