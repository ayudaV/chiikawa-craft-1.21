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
