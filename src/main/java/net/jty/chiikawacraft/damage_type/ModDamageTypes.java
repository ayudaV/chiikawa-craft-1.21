package net.jty.chiikawacraft.damage_type;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

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