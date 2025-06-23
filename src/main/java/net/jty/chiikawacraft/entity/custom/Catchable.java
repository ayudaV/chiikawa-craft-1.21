/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package net.jty.chiikawacraft.entity.custom;

import java.util.Optional;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public interface Catchable {
    boolean isFromBasket();

    void setFromBasket(boolean var1);

    void copyDataToStack(ItemStack var1);

    void copyDataFromNbt(NbtCompound var1);

    ItemStack getBasketItem();

    SoundEvent getBasketFillSound();

    @Deprecated
    static void copyDataToStack(MobEntity entity, ItemStack stack) {
        stack.set(DataComponentTypes.CUSTOM_NAME, entity.getCustomName());
        NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, stack, nbtCompound -> {
            if (entity.isAiDisabled()) {
                nbtCompound.putBoolean("NoAI", entity.isAiDisabled());
            }
            if (entity.isSilent()) {
                nbtCompound.putBoolean("Silent", entity.isSilent());
            }
            if (entity.hasNoGravity()) {
                nbtCompound.putBoolean("NoGravity", entity.hasNoGravity());
            }
            if (entity.isGlowingLocal()) {
                nbtCompound.putBoolean("Glowing", entity.isGlowingLocal());
            }
            if (entity.isInvulnerable()) {
                nbtCompound.putBoolean("Invulnerable", entity.isInvulnerable());
            }
            nbtCompound.putFloat("Health", entity.getHealth());
        });
    }

    @Deprecated
    static void copyDataFromNbt(MobEntity entity, NbtCompound nbt) {
        if (nbt.contains("NoAI")) {
            entity.setAiDisabled(nbt.getBoolean("NoAI"));
        }
        if (nbt.contains("Silent")) {
            entity.setSilent(nbt.getBoolean("Silent"));
        }
        if (nbt.contains("NoGravity")) {
            entity.setNoGravity(nbt.getBoolean("NoGravity"));
        }
        if (nbt.contains("Glowing")) {
            entity.setGlowing(nbt.getBoolean("Glowing"));
        }
        if (nbt.contains("Invulnerable")) {
            entity.setInvulnerable(nbt.getBoolean("Invulnerable"));
        }
        if (nbt.contains("Health", NbtElement.NUMBER_TYPE)) {
            entity.setHealth(nbt.getFloat("Health"));
        }
    }

    static <T extends LivingEntity> Optional<ActionResult> tryBasket(PlayerEntity player, Hand hand, T entity) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == Items.WATER_BUCKET && entity.isAlive()) {
            entity.playSound(((Catchable)((Object)entity)).getBasketFillSound(), 1.0f, 1.0f);
            ItemStack itemStack2 = ((Catchable)((Object)entity)).getBasketItem();
            ((Catchable)((Object)entity)).copyDataToStack(itemStack2);
            ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, player, itemStack2, false);
            player.setStackInHand(hand, itemStack3);
            World world = entity.getWorld();
            if (!world.isClient) {
                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)player, itemStack2);
            }
            entity.discard();
            return Optional.of(ActionResult.success(world.isClient));
        }
        return Optional.empty();
    }
}

