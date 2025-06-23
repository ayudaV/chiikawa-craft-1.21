package net.jty.chiikawacraft.item.custom;

import net.jty.chiikawacraft.entity.custom.Catchable;
import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

/**
 * AI Generated Documentation
 *
 * EntityBasketItem represents an item that contains an entity of a specific type,
 * allowing the entity to be stored and later released at a specific location in the game world.
 * It is a subclass of the {@code Item} class and provides custom functionality for
 * interacting with the world.
 *
 * The item is designed for usage scenarios where players can place the contained entity
 * into the world by right-clicking on a block while holding this item. The behavior includes:
 * - Spawning the associated entity in the world at the specified block location.
 * - Playing a sound when the entity is released.
 * - Modifying the item stack to represent an "emptied" state.
 *
 * Fields:
 * - {@code entityType}: The type of entity encapsulated by this item.
 * - {@code emptyingSound}: The sound played when the entity is released into the world.
 *
 * Constructor:
 * - Accepts the type of the entity, the sound to play on emptying, and the item settings.
 *
 * Methods:
 * - {@code useOnBlock}: Handles the player interaction when using this item on a block, releasing
 *   the entity and playing the emptying sound.
 * - {@code spawnEntity}: Spawns the entity at the specified location in the game world, copying any
 *   relevant data from the item stack to the spawned entity.
 * - {@code getEmptiedStack}: Returns the modified item stack that represents the emptied state of the
 *   basket. For non-creative mode players, this typically results in giving back an empty basket.
 * - {@code playEmptyingSound}: Plays the configured sound at the specified location to indicate
 *   the entity was released.
 */
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
