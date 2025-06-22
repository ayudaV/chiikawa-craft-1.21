package net.jty.chiikawacraft.entity.custom;

import net.jty.chiikawacraft.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UsagiEntity extends ChiikawaEntity {
    public UsagiEntity(EntityType<? extends ChiikawaEntity> entityType, World world) {
        super(entityType, world);
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
