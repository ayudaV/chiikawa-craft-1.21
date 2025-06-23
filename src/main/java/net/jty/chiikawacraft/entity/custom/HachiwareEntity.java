package net.jty.chiikawacraft.entity.custom;

import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.item.ModItems;
import net.jty.chiikawacraft.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * AI Generated Documentation
 * The HachiwareEntity class represents a specific type of Chiikawa-themed entity
 * introduced in the mod, extending the functionality of the AbstractChiikawaEntity base class.
 * This class defines unique behaviors, sounds, and interactions for the Hachiware entity.
 *
 * Key Features:
 * 1. Child Creation:
 *    Overrides the createChild method to ensure Hachiware entities reproduce
 *    to spawn another Hachiware instance.
 *
 * 2. Custom Basket Item:
 *    Specifies a unique basket item type associated with the Hachiware entity
 *    via the getBasketItem method.
 *
 * 3. Sound Customization:
 *    Defines specific ambient, hurt, and death sounds for the Hachiware entity
 *    by overriding the respective sound-related methods.
 *
 * Inherits Attributes and Behaviors:
 * As a subclass of AbstractChiikawaEntity, this class inherits common attributes
 * such as movement speed, health, and interaction capabilities. It also benefits
 * from reusable methods and goals declared in the abstract parent class, including:
 * - Animation handling.
 * - Interaction logic for capturing the entity.
 * - Goals for wandering, mating, and interaction with the player.
 *
 * Game Integration:
 * This entity type is registered in the ModEntities class, ensuring the Hachiware
 * entity is recognized by the game's ecosystem, including spawning and sound systems.
 *
 * Constructor:
 * The constructor initializes the HachiwareEntity within the game world, assigning
 * it an EntityType and World instance for proper gameplay integration.
 */
public class HachiwareEntity extends AbstractChiikawaEntity {
    public HachiwareEntity(EntityType<? extends AbstractChiikawaEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.HACHIWARE.create(world);
    }

    @Override
    public ItemStack getBasketItem() {
        return ModItems.HACHIWARE_BASKET.getDefaultStack();
    }

    /* SOUNDS */
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENTITY_HACHIWARE_IDLE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENTITY_HACHIWARE_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENTITY_HACHIWARE_DEATH;
    }
}
