package net.jty.chiikawacraft.item.custom;

import net.jty.chiikawacraft.entity.custom.Catchable;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class BasketItem extends Item {
    private final EntityType<?> entityType;
    private final SoundEvent emptyingSound;
    public BasketItem(Settings settings, EntityType<?> entityType, SoundEvent emptyingSound) {
        super(settings);
        this.entityType = entityType;
        this.emptyingSound = emptyingSound;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        assert context.getPlayer() != null;
        spawnEntity((ServerWorld) context.getWorld(), context.getPlayer().getMainHandStack(), context.getBlockPos());
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
}
