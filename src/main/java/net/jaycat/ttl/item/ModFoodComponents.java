package net.jaycat.ttl.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    public static final FoodComponent PIZZA_SLICE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.55f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,  1200, 1), 0.30f ).build();
// there are 20 ticks per second
}
