package com.st0x0ef.stellaris.common.registry;

import net.minecraft.world.food.FoodProperties;

public class FoodRegistry {
    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(3).saturationModifier(1).build();
    public static final FoodProperties BERRY_JUICE = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.4F).build();
    public static final FoodProperties COSMO_BREAD = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).build();
    public static final FoodProperties COSMO_COFFEE = (new FoodProperties.Builder()).nutrition(5).saturationModifier(0.3F).build();
}
