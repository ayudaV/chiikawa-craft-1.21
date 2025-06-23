package net.jty.chiikawacraft;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.jty.chiikawacraft.datagen.*;
import net.jty.chiikawacraft.item.ModArmorMaterials;
import net.jty.chiikawacraft.world.ModConfiguredFeatures;
import net.jty.chiikawacraft.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

/**
 * AI Generated Documentation
 * The ChiikawaCraftDataGenerator class is responsible for managing the data generation
 * process for the ChiikawaCraft mod. This includes initializing and configuring various
 * data providers such as block tags, item tags, loot tables, models, and recipes.
 * Additionally, it registers mod-specific configured and placed features in the Minecraft
 * registry.
 *
 * This class implements the {@code DataGeneratorEntrypoint} interface to hook into the
 * data generation process of the Fabric API and ensures all relevant data is generated
 * according to the mod's requirements.
 *
 * Methods:
 * - {@code onInitializeDataGenerator}: Initializes the Fabric data generator, creating
 *   a data pack and adding all necessary providers to generate mod data such as block
 *   tags, item tags, loot tables, models, and recipes.
 * - {@code buildRegistry}: Registers configured and placed features for the mod using
 *   the provided {@code RegistryBuilder} instance.
 *
 * Responsibilities:
 * - Invoking all providers required to generate data specific to the ChiikawaCraft mod.
 * - Registering mod-specific features into the appropriate registries.
 */
public class ChiikawaCraftDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
