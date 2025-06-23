package net.jty.chiikawacraft.sound;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

/**
 * AI Generated Documentation
 * The ModSounds class is responsible for registering and managing custom sound events
 * used within the ChiikawaCraft mod. It defines a set of sound events corresponding to
 * various entity actions, such as death, hurt, and idle sounds for specific entities.
 *
 * These sound events are statically initialized and registered to the game's sound registry
 * using a private utility method, `registerSoundEvent`. The registered sounds are categorized
 * for different entities, including Chiikawa, Hachiwara, and Usagi.
 *
 * This class also provides a method to log the registration of sound events during the
 * initialization phase of the mod.
 *
 * Responsibilities:
 * - Define mod-specific sound events as constants.
 * - Register these sounds to the game's sound registry with unique identifiers.
 * - Log the sound registration process for debugging or informational purposes.
 *
 * Key Sound Events:
 * - ENTITY_CHIIKAWA_DEATH, ENTITY_CHIIKAWA_HURT, ENTITY_CHIIKAWA_IDLE
 * - ENTITY_HACHIWARE_DEATH, ENTITY_HACHIWARE_HURT, ENTITY_HACHIWARE_IDLE
 * - ENTITY_USAGI_DEATH, ENTITY_USAGI_HURT, ENTITY_USAGI_IDLE
 *
 * Methods:
 * - `registerSoundEvent(String name)`: Registers a sound event with the specified name
 *   by creating a unique identifier and adding it to the game's registry.
 * - `registerSounds()`: Logs the registration of all mod-defined sound events.
 */
public class ModSounds {
    public static final SoundEvent ENTITY_CHIIKAWA_DEATH = registerSoundEvent("entity_chiikawa_death");
    public static final SoundEvent ENTITY_CHIIKAWA_HURT = registerSoundEvent("entity_chiikawa_hurt");
    public static final SoundEvent ENTITY_CHIIKAWA_IDLE = registerSoundEvent("entity_chiikawa_idle");

    public static final SoundEvent ENTITY_HACHIWARE_DEATH = registerSoundEvent("entity_hachiware_death");
    public static final SoundEvent ENTITY_HACHIWARE_HURT = registerSoundEvent("entity_hachiware_hurt");
    public static final SoundEvent ENTITY_HACHIWARE_IDLE = registerSoundEvent("entity_hachiware_idle");

    public static final SoundEvent ENTITY_USAGI_DEATH = registerSoundEvent("entity_usagi_death");
    public static final SoundEvent ENTITY_USAGI_HURT = registerSoundEvent("entity_usagi_hurt");
    public static final SoundEvent ENTITY_USAGI_IDLE = registerSoundEvent("entity_usagi_idle");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(ChiikawaCraft.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        ChiikawaCraft.LOGGER.info("Registering Mod Sounds for " + ChiikawaCraft.MOD_ID);
    }
}