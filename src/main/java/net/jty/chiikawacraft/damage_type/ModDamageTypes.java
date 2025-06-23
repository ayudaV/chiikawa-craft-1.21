package net.jty.chiikawacraft.damage_type;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

/**
 * ModDamageTypes is a utility class responsible for managing custom damage types
 * used by the ChiikawaCraft mod. It provides functionality for registering and
 * referencing mod-specific damage types, and constructing relevant instances of
 * {@code DamageSource}.
 *
 * Key Responsibilities:
 * - Defining custom damage types as constants, such as {@code YOROI_DAMAGE_TYPE}.
 * - Providing a utility method ({@code of}) to create {@code DamageSource}
 *   instances associated with specified damage types in the given world context.
 * - Registering all custom damage types used within the mod.
 *
 * Fields:
 * - {@code YOROI_DAMAGE_TYPE}: A {@code RegistryKey<DamageType>} instance representing
 *   the "yoroi damage type," identified by a specific JSON configuration.
 *
 * Methods:
 * - {@code of(World world, RegistryKey<DamageType> key)}: Generates a {@code DamageSource}
 *   object based on a provided world and a specified custom damage type.
 * - {@code registerModDamageTypes()}: Logs the registration of all custom damage types
 *   for the mod during initialization.
 */
public class ModDamageTypes {

    /*
     * Store the RegistryKey of our DamageType into a new constant called YOROI_DAMAGE_TYPE
     * The Identifier in use here points to our JSON file we created earlier.
     */
    public static final RegistryKey<DamageType> YOROI_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ChiikawaCraft.MOD_ID, "yoroi_damage_type"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
    public static void registerModDamageTypes() {
        ChiikawaCraft.LOGGER.info("Registering Mod Damage Types for: " + ChiikawaCraft.MOD_ID);
    }
}