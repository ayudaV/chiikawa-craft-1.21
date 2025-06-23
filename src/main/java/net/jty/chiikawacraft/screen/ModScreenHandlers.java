package net.jty.chiikawacraft.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.screen.custom.HealerScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

/**
 * The ModScreenHandlers class is responsible for registering and managing custom screen handlers
 * for the ChiikawaCraft mod. Screen handlers are used to manage server-side logic for user interfaces
 * and ensure synchronization between the client and server.
 *
 * Responsibilities:
 * - Defines and registers all screen handlers used in the ChiikawaCraft mod.
 * - Provides a centralized location for maintaining screen handler types.
 *
 * Key Features:
 * - Includes a static reference to HEALER_SCREEN_HANDLER, a screen handler type that facilitates interaction
 *   with the Healer feature in the mod.
 * - Utilizes the Fabric API to register the HEALER_SCREEN_HANDLER in the game registry.
 *
 * Methods:
 * - registerScreenHandlers():
 *   Initializes the registration of all screen handlers and logs the registration process to confirm
 *   successful setup. This method should be called during mod initialization.
 *
 * Constants:
 * - HEALER_SCREEN_HANDLER:
 *   Represents the screen handler type for the Healer feature. This handler manages the
 *   server-side logic for the relevant inventory and UI interaction.
 */
public class ModScreenHandlers {
    public static final ScreenHandlerType<HealerScreenHandler> HEALER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(ChiikawaCraft.MOD_ID, "healer_screen_handler"),
                    new ExtendedScreenHandlerType<>(HealerScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        ChiikawaCraft.LOGGER.info("Registering Screen Handlers for " + ChiikawaCraft.MOD_ID);
    }
}