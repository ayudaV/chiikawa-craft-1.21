package net.jty.chiikawacraft.block.entity;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.block.ModBlocks;
import net.jty.chiikawacraft.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ChiikawaCraft.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));

    public static void registerBlockEntities() {
        ChiikawaCraft.LOGGER.info("Registering Block Entities for " + ChiikawaCraft.MOD_ID);
    }
}