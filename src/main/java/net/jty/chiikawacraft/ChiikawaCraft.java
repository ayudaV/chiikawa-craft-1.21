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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main class for the ChiikawaCraft mod. This class implements the {@link ModInitializer}
 * interface from the Fabric API to initialize and register all the components of the mod.
 *
 * Responsibilities of this class include:
 * - Setting up the logger for the mod.
 * - Registering mod-specific features such as items, blocks, entities, and custom events.
 * - Ensuring world generation and screen handlers are properly initialized.
 *
 * The {@code onInitialize()} method is executed during the mod's initialization phase.
 * It is called when Minecraft and the Fabric environment are ready for mod initialization,
 * though resources and some other components may still be uninitialized at this stage.
 *
 * Key components registered in this mod:
 * - Custom item groups for organizing items.
 * - Mod-specific items, blocks, entities, and their attributes.
 * - Custom damage types and sound events.
 * - World generation features and screen handlers.
 */
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
