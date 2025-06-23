package net.jty.chiikawacraft.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * AI Generated Documentation
 * Embora não utilizado, se trata de uma ferramenta importantissima no desenvolvimento de mods
 * pois possibilita a insersão de código em métodos do proprio jogo.
 * A mixin class used to inject custom behavior into the MinecraftServer's loadWorld method.
 *
 * This class modifies the behavior of the {@code loadWorld()} method by injecting code at the
 * start (HEAD) of the method execution. The injection is achieved using the Fabric Mixins system,
 * which allows modifications to existing classes without directly editing their code.
 *
 * The {@code init()} method is automatically called during the targeted method execution to
 * apply the intended enhancements or changes.
 *
 * Mixin configuration for this class is defined in the mod's mixin JSON file.
 *
 * Annotations:
 * - {@code @Mixin(MinecraftServer.class)}: Defines the mixin target class, which is the
 *   {@link MinecraftServer}.
 * - {@code @Inject}: Specifies the injection point and method at which this modification occurs.
 *   The injection target is the {@code loadWorld()} method, and the injection occurs at its
 *   beginning.
 *
 * Notes:
 * - This is part of the Chiikawa Craft mod and is initialized during the mod's entry point.
 * - Any runtime issues caused by mixin conflicts or incorrect injections should be resolved
 *   by verifying the mixin configuration and code implementation.
 */
@Mixin(MinecraftServer.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
	}
}