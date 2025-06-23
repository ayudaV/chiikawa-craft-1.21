package net.jty.chiikawacraft.screen.custom;

import net.jty.chiikawacraft.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

/**
 * AI Generated Documentation
 * Study only, Not Implemented in final game
 * HealerScreenHandler is responsible for managing the server-side logic of the Healer Screen
 * in the ChiikawaCraft mod. It extends the ScreenHandler class and connects the player
 * inventory with the inventory/block entity related to the Healer feature.
 *
 * This class handles:
 * - Setting up slots for the inventory, including the healer-specific slot and the player inventory.
 * - Managing item transfer logic between the healer inventory and the player's inventory.
 * - Ensuring that only a single item can be placed in the healer-specific inventory slot.
 *
 * Key Features:
 * - Provides a slot system for both the healer's block entity and the player's inventory.
 * - Implements quick transfer functionality to enable seamless item movement across inventories.
 * - Checks if a player is allowed to interact with the inventory using the canUse method.
 *
 * Constructor Overview:
 * - HealerScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos):
 *   Initializes the screen handler using the block entity at the given position.
 * - HealerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity):
 *   Directly initializes the screen handler with the specified block entity.
 *
 * Method Overview:
 * - quickMove(PlayerEntity player, int invSlot):
 *   Handles shift-click functionality to transfer items between healer and player inventories.
 * - canUse(PlayerEntity player):
 *   Ensures that the specified player can interact with the healer inventory.
 * - addPlayerInventory(PlayerInventory playerInventory):
 *   Adds the player's main inventory slots to the screen handler.
 * - addPlayerHotbar(PlayerInventory playerInventory):
 *   Adds the player's hotbar slots to the screen handler.
 */
public class HealerScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public HealerScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(pos));
    }

    public HealerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(ModScreenHandlers.HEALER_SCREEN_HANDLER, syncId);
        this.inventory = ((Inventory) blockEntity);

        this.addSlot(new Slot(inventory, 0, 80, 35) {
            @Override
            public int getMaxItemCount() {
                return 1;
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}