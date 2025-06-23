package net.jty.chiikawacraft.entity.custom;

import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.item.ModItems;
import net.jty.chiikawacraft.sound.ModSounds;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


/**
 * AI Generated Documentation
 * Represents the ChiikawaEntity, a friendly and catchable creature introduced
 * in the ChiikawaCraft mod. This entity extends the AbstractChiikawaEntity
 * and inherits its core functionality while overriding specific behaviors and
 * properties such as sounds and child creation.
 *
 * Features:
 * - Capable of creating new child entities of the same type when bred.
 * - Emits custom sounds for ambient, hurt, and death events.
 * - Associated with a specific basket item used for catching or storage.
 *
 * Behavior:
 * - Implements the createChild method to return a new ChiikawaEntity
 *   when breeding occurs in a ServerWorld.
 * - Provides custom sounds for idle, hurt, and death events using the
 *   sound resources defined in ModSounds.
 * - Returns a specific basket item through the getBasketItem method,
 *   allowing players to interact with and catch this entity.
 *
 * Designed for integration into the mod's ecosystem, following the behaviors
 * and rules established by its abstract parent class and associated interfaces.
 */
public class ChiikawaEntity extends AbstractChiikawaEntity {

    public ChiikawaEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.CHIIKAWA.create(world);
    }

    @Override
    public ItemStack getBasketItem() {
        return ModItems.CHIIKAWA_BASKET.getDefaultStack();
    }
    /* SOUNDS */
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENTITY_CHIIKAWA_IDLE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENTITY_CHIIKAWA_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENTITY_CHIIKAWA_DEATH;
    }
}
