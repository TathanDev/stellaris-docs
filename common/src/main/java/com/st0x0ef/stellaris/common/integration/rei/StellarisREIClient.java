package com.st0x0ef.stellaris.common.integration.rei;

import com.st0x0ef.stellaris.client.screens.RocketStationScreen;
import com.st0x0ef.stellaris.common.data.recipes.RocketStationRecipe;
import com.st0x0ef.stellaris.common.integration.rei.rocket_station.RocketStationCategory;
import com.st0x0ef.stellaris.common.integration.rei.rocket_station.RocketStationDisplay;
import com.st0x0ef.stellaris.common.registry.BlocksRegistry;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class StellarisREIClient implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new RocketStationCategory());

        registry.addWorkstations(RocketStationCategory.ROCKET_STATION, EntryStacks.of(BlocksRegistry.ROCKET_STATION.get()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(RocketStationRecipe.class, RocketStationRecipe.Type.INSTANCE,
                RocketStationDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), RocketStationScreen.class,
                RocketStationCategory.ROCKET_STATION);
    }

}
