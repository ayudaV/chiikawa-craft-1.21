package net.jty.chiikawacraft.entity;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.ChiikawaEntity;
import net.jty.chiikawacraft.entity.custom.HachiwareEntity;
import net.jty.chiikawacraft.entity.custom.UsagiEntity;
import net.jty.chiikawacraft.entity.custom.YoroiEntity;
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

    public static final EntityType<HachiwareEntity> HACHIWARE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChiikawaCraft.MOD_ID, "hachiware_entity"),
            EntityType.Builder.create(HachiwareEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.7f, 1f).build());

    public static final EntityType<UsagiEntity> USAGI = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChiikawaCraft.MOD_ID, "usagi_entity"),
            EntityType.Builder.create(UsagiEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.7f, 1f).build());

    public static final EntityType<YoroiEntity> YOROI = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChiikawaCraft.MOD_ID, "yoroi_entity"),
            EntityType.Builder.create(YoroiEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.7f, 1.8f).build());

    public static void registerModEntities() {
        ChiikawaCraft.LOGGER.info("Registering Mod Entities for: " + ChiikawaCraft.MOD_ID);
    }
}
