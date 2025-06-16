package net.jty.chiikawacraft.entity;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.ChiikawaEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ChiikawaEntity> CHIIKAWA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChiikawaCraft.MOD_ID, "chiikawa_entity"),
            EntityType.Builder.create(ChiikawaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.7f, 1f).build());
    public static void registerModEntities() {
        ChiikawaCraft.LOGGER.info("Registering Mod Entities for: " + ChiikawaCraft.MOD_ID);
    }
}
