package com.st0x0ef.stellaris.common.integration.rei.rocket_station;

import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.common.registry.BlocksRegistry;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.LinkedList;
import java.util.List;

public class RocketStationCategory implements DisplayCategory<BasicDisplay> {
    public static final ResourceLocation TEXTURE =
            new ResourceLocation(Stellaris.MODID, "textures/gui/rocket_station.png");
    public static final CategoryIdentifier<RocketStationDisplay> ROCKET_STATION =
            CategoryIdentifier.of(Stellaris.MODID, "rocket_station");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return ROCKET_STATION;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Rocket Station");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BlocksRegistry.ROCKET_STATION.get().asItem());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 177, 144)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 11))
                .entries(display.getInputEntries().get(0)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 59))
                .markOutput().entries(display.getOutputEntries().get(0)));


        return widgets;
    }

}
