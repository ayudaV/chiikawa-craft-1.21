package net.jty.chiikawacraft.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.item.ModItems;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

/**
 * Handles the registration of custom mod events in the ChiikawaCraft mod.
 * This class is primarily responsible for defining and integrating custom event behaviors
 * that react to specific game occurrences, such as entity deaths or other server-based actions.
 *
 * Features:
 * - Integration with server-side events via the Fabric API, ensuring mod-specific behavior
 *   reacts appropriately to game events.
 * - Implementation of event-driven logic for player actions and interactions.
 * - Custom behavior when a player entity meets specific conditions (e.g., wearing specific
 *   armor pieces).
 *
 * Key Event:
 * - The `ServerLivingEntityEvents.ALLOW_DEATH` event is overridden to allow custom behaviors
 *   when player entities are wearing a predefined set of armor, defined in the mod.
 *   The conditions and outcomes include:
 *   - Detecting if the player is equipped with specific armor (e.g., Iron Yoroi Helmet).
 *   - Sending a message to the player upon meeting the conditions.
 *   - Spawning a custom mod-specific entity (e.g., Yoroi) under specific conditions.
 *   - Decreasing the durability or removing affected armor items post-event.
 */
public class ModCustomEvents {
    public static void registerModEvents() {
        ChiikawaCraft.LOGGER.info("Registering Mod Events for: " + ChiikawaCraft.MOD_ID);

        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
            if (entity instanceof PlayerEntity player) {
                ItemStack boots = player.getInventory().getArmorStack(0);
                ItemStack leggings = player.getInventory().getArmorStack(1);
                ItemStack breastplate = player.getInventory().getArmorStack(2);
                ItemStack helmet = player.getInventory().getArmorStack(3);

                if (helmet.getItem() == ModItems.IRON_YOROI_HELMET && breastplate.getItem() == Items.IRON_CHESTPLATE
                        && leggings.getItem() == Items.IRON_LEGGINGS && boots.getItem() == Items.IRON_BOOTS) {
                    player.sendMessage(Text.literal("Summoning by the mind control of Chiikawa's"));
                    helmet.decrement(1);
                    breastplate.decrement(1);
                    leggings.decrement(1);
                    boots.decrement(1);
                    ModEntities.YOROI.spawn((ServerWorld) player.getWorld(), BlockPos.ofFloored(player.getPos()), SpawnReason.CONVERSION);
                }
            }
            return true;
        });
    }
}
