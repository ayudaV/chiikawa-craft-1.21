package net.jty.chiikawacraft.entity.custom;

import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.item.ModItems;
import net.jty.chiikawacraft.sound.ModSounds;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class ChiikawaEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private  int idleAnimationTimeout = 0;
    //private static final TrackedData<Boolean> FROM_BUCKET = DataTracker.registerData(ChiikawaEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public ChiikawaEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(ModItems.PANCAKE), true));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 18)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

//    public ActionResult interactMob(PlayerEntity player, Hand hand) {
//        return Bucketable.tryBucket(player, hand, this).orElse(super.interactMob(player, hand));
//    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.PANCAKE);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.CHIIKAWA.create(world);
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

//    @Override
//    public boolean isFromBucket() {
//        return this.dataTracker.get(FROM_BUCKET);
//    }
//    @Override
//    public void setFromBucket(boolean fromBucket) {
//        this.dataTracker.set(FROM_BUCKET, fromBucket);
//    }
//
//
//
//
//    @Override
//    public void copyDataToStack(ItemStack stack) {
//        Bucketable.copyDataToStack(this, stack);
//        NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, stack, nbt -> {
//            nbt.putInt("Age", this.getBreedingAge());
//        });
//    }
//
//    @Override
//    public void copyDataFromNbt(NbtCompound nbt) {
//        Bucketable.copyDataFromNbt(this, nbt);
//        if (nbt.contains("Age")) {
//            this.setBreedingAge(nbt.getInt("Age"));
//        }
//        if (nbt.contains("HuntingCooldown")) {
//            this.getBrain().remember(MemoryModuleType.HAS_HUNTING_COOLDOWN, true, nbt.getLong("HuntingCooldown"));
//        }
//    }
//
//    @Override
//    public ItemStack getBucketItem() {
//        return new ItemStack(Items.AXOLOTL_BUCKET);
//    }
//
//    @Override
//    public SoundEvent getBucketFillSound() {
//        return SoundEvents.ITEM_BUCKET_FILL_AXOLOTL;
//    }
}
