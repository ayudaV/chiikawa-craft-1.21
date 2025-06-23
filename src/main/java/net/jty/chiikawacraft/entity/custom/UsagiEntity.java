package net.jty.chiikawacraft.entity.custom;

import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.item.ModItems;
import net.jty.chiikawacraft.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * AI Generated Documentation
 * Represents the UsagiEntity, a rabbit-themed custom entity in the ChiikawaCraft mod.
 * This class extends the AbstractChiikawaEntity and provides specific functionality
 * and properties unique to the UsagiEntity.
 *
 * Functionalities:
 * - Creates a child entity of the UsagiEntity type when breeding occurs.
 * - Returns a specific basket item associated with the UsagiEntity.
 * - Defines unique sound effects for idle, hurt, and death states.
 *
 * Key Features:
 * - Implements behavior specific to the UsagiEntity, such as unique sounds and items.
 * - Overrides required methods from the AbstractChiikawaEntity to ensure
 *   compatibility and customization within the mod.
 *
 * Usage:
 * This entity is part of the ChiikawaCraft mod and is registered in the ModEntities
 * class. It is designed to behave within the mod's ecosystem, supporting unique
 * animations, sounds, and interactions tailored for the UsagiEntity.
 */
public class UsagiEntity extends AbstractChiikawaEntity {
    public UsagiEntity(EntityType<? extends AbstractChiikawaEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.USAGI.create(world);
    }
    @Override
    public ItemStack getBasketItem() {
        return ModItems.USAGI_BASKET.getDefaultStack();
    }
    /* SOUNDS */
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENTITY_USAGI_IDLE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENTITY_USAGI_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENTITY_USAGI_DEATH;
    }
}
