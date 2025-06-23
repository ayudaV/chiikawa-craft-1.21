package net.jty.chiikawacraft.world.gen;

/**
 * AI Generated Documentation
 * The ModWorldGeneration class is responsible for initializing the world generation process
 * for the custom modded content. It integrates both ore generation and entity spawn
 * behavior into the game's biome modification system.
 *
 * Responsibilities:
 * - Invokes the ModOreGeneration class to register custom ores during world generation.
 * - Invokes the ModEntitySpawns class to register custom entity spawns in specific biomes.
 *
 * Primary Method:
 * - generateModWorldGen: Combines the ore generation process and entity spawn registration
 *   into a single initialization step. This ensures that custom features of the mod are
 *   properly integrated when the game generates its world.
 *
 * Dependencies:
 * - The ModOreGeneration class for registering custom ores.
 * - The ModEntitySpawns class for managing the spawning rules and restrictions of custom entities.
 */
public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModEntitySpawns.addSpawns();
    }
}