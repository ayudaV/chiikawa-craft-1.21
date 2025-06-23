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
import net.minecraft.util.math.BlockPos;

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
