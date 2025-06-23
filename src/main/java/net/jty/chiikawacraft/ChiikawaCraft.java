package net.jty.chiikawacraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.jty.chiikawacraft.block.ModBlocks;
import net.jty.chiikawacraft.damage_type.ModDamageTypes;
import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.entity.custom.ChiikawaEntity;
import net.jty.chiikawacraft.entity.custom.HachiwareEntity;
import net.jty.chiikawacraft.entity.custom.UsagiEntity;
import net.jty.chiikawacraft.entity.custom.YoroiEntity;
import net.jty.chiikawacraft.events.ModCustomEvents;
import net.jty.chiikawacraft.item.ModItemGroups;
import net.jty.chiikawacraft.item.ModItems;
import net.jty.chiikawacraft.screen.ModScreenHandlers;
import net.jty.chiikawacraft.sound.ModSounds;
import net.jty.chiikawacraft.world.gen.ModWorldGeneration;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChiikawaCraft implements ModInitializer {
	public static final String MOD_ID = "chiikawacraft";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModDamageTypes.registerModDamageTypes();
		ModSounds.registerSounds();
		ModCustomEvents.registerModEvents();

		FabricDefaultAttributeRegistry.register(ModEntities.CHIIKAWA, ChiikawaEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.HACHIWARE, HachiwareEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.USAGI, UsagiEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.YOROI, YoroiEntity.createAttributes());

		ModWorldGeneration.generateModWorldGen();
		ModScreenHandlers.registerScreenHandlers();

	}
}
