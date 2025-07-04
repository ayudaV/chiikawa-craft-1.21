package net.jty.chiikawacraft.entity.custom;

import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * AI Generated Documentation
 * The AbstractChiikawaEntity class represents a base entity designed to model Chiikawa-themed
 * creatures within a mod. It extends the AnimalEntity class and implements the Catchable
 * interface, making it capable of being interacted with, bred, and caught by the player.
 *
 * Core Features:
 * - Implements custom behaviors for animations, data tracking, and interaction.
 * - Provides methods to determine if an entity originates from a basket and enable
 *   data transfer between the entity and item representations.
 *
 * Attributes:
 * - Contains attributes such as health, movement speed, attack damage, and follow range,
 *   configurable via the createAttributes method.
 * - Includes an idle animation state with a configurable timeout to control animations.
 *
 * Goals:
 * - Configures several common goals for the entity, such as swimming, mating,
 *   following parents, interacting with players, and wandering.
 *
 * Data Persistence:
 * - Overrides methods for saving and loading entity data using NBT, ensuring compatibility
 *   between the entity's state and its item representation.
 *
 * Customization and Extension:
 * - Serves as a parent class for specific Chiikawa entities, delegating details such as
 *   ambient, hurt, and death sounds to subclasses.
 * - Requires subclasses to implement the createChild method for breeding functionality,
 *   allowing the creation of new entities in the game world.
 *
 * Interaction and Catching:
 * - Overrides the interactMob method to integrate catching mechanics using the Catchable
 *   interface, allowing players to catch these entities with designated items.
 *
 * Sound Behavior:
 * - Abstract methods for retrieving ambient, hurt, and death sounds provide a framework
 *   for each subclass to define its unique audio cues.
 *
 * Animation:
 * - Includes functionality to control animation states, providing entities with visual feedback
 *   for idle movements.
 */
public abstract class AbstractChiikawaEntity extends AnimalEntity implements Catchable{
    public final AnimationState idleAnimationState = new AnimationState();
    private  int idleAnimationTimeout = 0;
    private static final TrackedData<Boolean> FROM_BASKET = DataTracker.registerData(AbstractChiikawaEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    protected AbstractChiikawaEntity(EntityType<? extends AnimalEntity> entityType, World world) {
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

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        return Catchable.tryCatch(player, hand, this).orElse(super.interactMob(player, hand));
    }


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

    public abstract PassiveEntity createChild(ServerWorld world, PassiveEntity entity);


    /* SOUNDS */
    protected abstract SoundEvent getAmbientSound();

    protected abstract SoundEvent getHurtSound(DamageSource source);

    protected abstract SoundEvent getDeathSound();

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(FROM_BASKET, false);
    }

    @Override
    public boolean isFromBasket() {
        return this.dataTracker.get(FROM_BASKET);
    }

    @Override
    public void setFromBasket(boolean fromBasket) {
        this.dataTracker.set(FROM_BASKET, fromBasket);
    }


    @Override
    public void copyDataToStack(ItemStack stack) {
        Catchable.copyDataToStack(this, stack);
    }


    @Override
    public void copyDataFromNbt(NbtCompound nbt) {
        Catchable.copyDataFromNbt(this, nbt);
    }


    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("FromBasket", this.isFromBasket());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setFromBasket(nbt.getBoolean("FromBasket"));
    }

    @Override
    public boolean cannotDespawn() {
        return isFromBasket() && super.cannotDespawn();
    }
    @Override
    public SoundEvent getBasketFillSound() {
        return SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER;
    }
}
