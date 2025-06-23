package net.jty.chiikawacraft.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

/**
 * A utility class that defines custom food components for use in modded items.
 * This class primarily serves as a central repository for custom food definitions
 * to be used in conjunction with items to provide specific nutritional and status effects.
 *
 * Food components are defined with properties such as nutrition, saturation modifiers,
 * and optional status effects with probabilities.
 *
 * Features:
 * - Definition of food components with nutritional values.
 * - Assignment of saturation modifiers for fullness after eating.
 * - Status effects that may trigger upon consumption.
 *
 * Use this class to define the food properties of modded items and share them across
 * multiple instances of items requiring the same properties.
 */
public class ModFoodComponents {
    public static final FoodComponent PANCAKE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200), 0.15f).build();

}