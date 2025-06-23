package net.jty.chiikawacraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.jty.chiikawacraft.block.ModBlocks;
import net.jty.chiikawacraft.block.entity.ModBlockEntities;
import net.jty.chiikawacraft.block.entity.renderer.PedestalBlockEntityRenderer;
import net.jty.chiikawacraft.damage_type.ModDamageTypes;
import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.entity.custom.ChiikawaEntity;
import net.jty.chiikawacraft.entity.custom.HachiwareEntity;
import net.jty.chiikawacraft.entity.custom.UsagiEntity;
import net.jty.chiikawacraft.entity.custom.YoroiEntity;
import net.jty.chiikawacraft.events.ModCustomEvents;
import net.jty.chiikawacraft.item.ModItemGroups;
import net.jty.chiikawacraft.item.ModItems;
import net.jty.chiikawacraft.item.custom.ModArmorItem;
import net.jty.chiikawacraft.screen.ModScreenHandlers;
import net.jty.chiikawacraft.sound.ModSounds;
import net.jty.chiikawacraft.util.YoroiDeath;
import net.jty.chiikawacraft.world.gen.ModWorldGeneration;
import net.jty.chiikawacraft.screen.custom.PedestalScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
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
		ModBlockEntities.registerBlockEntities();
		ModEntities.registerModEntities();
		ModDamageTypes.registerModDamageTypes();
		ModSounds.registerSounds();
		ModCustomEvents.registerModEvents();

		BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

		FabricDefaultAttributeRegistry.register(ModEntities.CHIIKAWA, ChiikawaEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.HACHIWARE, HachiwareEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.USAGI, UsagiEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.YOROI, YoroiEntity.createAttributes());

		ModWorldGeneration.generateModWorldGen();
		ModScreenHandlers.registerScreenHandlers();

	}
}
