package net.jty.chiikawacraft.item.custom;

import net.jty.chiikawacraft.entity.custom.Catchable;
import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class EntityBasketItem extends Item  {
    private final EntityType<?> entityType;
    private final SoundEvent emptyingSound;
    public EntityBasketItem(EntityType<?> entityType, SoundEvent emptyingSound, Settings settings) {
        super(settings);
        this.entityType = entityType;
        this.emptyingSound = emptyingSound;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();
        assert player != null;
        if (world instanceof ServerWorld) {
            this.spawnEntity((ServerWorld)world, stack, pos);
            world.emitGameEvent(player, GameEvent.ENTITY_PLACE, pos);
            playEmptyingSound(player, world, pos);
            stack.decrement(1);
            player.giveItemStack(getEmptiedStack(stack, player));
        }
        return super.useOnBlock(context);
    }

    private void spawnEntity(ServerWorld world, ItemStack stack, BlockPos pos) {
        Object entity = this.entityType.spawnFromItemStack(world, stack, null, pos, SpawnReason.BUCKET, true, false);
        if (entity instanceof Catchable catchable) {
            NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT);
            catchable.copyDataFromNbt(nbtComponent.copyNbt());
            catchable.setFromBasket(true);
        }
    }

    public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return !player.isInCreativeMode() ? new ItemStack(ModItems.BASKET) : stack;
    }

    protected void playEmptyingSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos) {
        world.playSound(player, pos, this.emptyingSound, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }
}
