package net.jty.chiikawacraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jty.chiikawacraft.block.ModBlocks;
import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIVING_GEM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIVING_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIVING_GEM_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LIVING_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_LIVING_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANCAKE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHIIKAWA_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.HACHIWARE_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.USAGI_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.YOROI_SPAWN_EGG, new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IRON_YOROI_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GOLD_YOROI_HELMET));
    }
}
