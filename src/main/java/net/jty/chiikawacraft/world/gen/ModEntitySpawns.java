package net.jty.chiikawacraft.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jty.chiikawacraft.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

/**
 * AI Generated Documentation
 * The ModEntitySpawns class is responsible for registering the spawn behavior of
 * custom modded entities into the game's world generation. It specifies which
 * biomes the entities can spawn in, their spawn groups, and their spawn rates.
 * Additionally, it defines the spawn restrictions for the entities to ensure
 * they spawn under appropriate conditions.
 *
 * Responsibilities:
 * - Registering spawn rules for modded entities in specific biomes.
 * - Restricting the spawn locations of modded entities based on height maps
 *   and natural spawn validation.
 *
 * Entities Registered:
 * - CHIIKAWA: Spawns in PLAINS and CHERRY_GROVE biomes with a spawn weight of
 *   30, and group sizes ranging from 3 to 7.
 * - HACHIWARE: Spawns in PLAINS, TAIGA, and LUSH_CAVES biomes with a spawn
 *   weight of 30, and group sizes ranging from 1 to 2.
 * - USAGI: Spawns in PLAINS and DESERT biomes with a spawn weight of 30, and
 *   group sizes ranging from 1 to 3.
 *
 * Usage:
 * - This class is invoked by the ModWorldGeneration class during the mod's
 *   initialization to integrate entity spawns into the world generation process.
 */
public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.CHERRY_GROVE),
                SpawnGroup.CREATURE, ModEntities.CHIIKAWA, 30, 3, 7);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.TAIGA, BiomeKeys.LUSH_CAVES),
                SpawnGroup.CREATURE, ModEntities.HACHIWARE, 30, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.DESERT),
                SpawnGroup.CREATURE, ModEntities.USAGI, 30, 1, 3);

        SpawnRestriction.register(ModEntities.CHIIKAWA, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        SpawnRestriction.register(ModEntities.HACHIWARE, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        SpawnRestriction.register(ModEntities.USAGI, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

    }
}