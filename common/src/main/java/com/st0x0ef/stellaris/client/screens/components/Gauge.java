package com.st0x0ef.stellaris.client.screens.components;

import com.mojang.blaze3d.systems.RenderSystem;
import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.client.screens.helper.ScreenHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

@Environment(EnvType.CLIENT)
public class Gauge extends AbstractWidget {
    private ResourceLocation overlay_texture;

    private int xTexStart;
    private int yTexStart;

    private int yDiffText;

    private int textureWidth;
    private int textureHeight;

    private int value;
    private int max_value;

    public static final ResourceLocation FLUID_TANK_OVERLAY = new ResourceLocation(Stellaris.MODID, "textures/gui/util/fluid_tank_overlay.png");


    public Gauge(int x, int y, int width, int height, Component message, ResourceLocation overlay_texture, int value, int max_value) {
        super(x, y, width, height, message);
        this.yDiffText = 0;
        this.xTexStart = 0;
        this.yTexStart = 0;
        this.overlay_texture = overlay_texture;
        this.max_value = max_value;
        this.value = value;

    }

    @Override
    public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        if (value > max_value) {
            value = max_value;
            graphics.blit(overlay_texture, getX(), getY(), width, height - 1, width, height -1, width, height - 1);
        } else {
            graphics.blit(overlay_texture, getX(), getY() + 45 - (int) (value / (max_value / 10) * 4.5), (float) width, (float) (height - (max_value / 1000 - value / (max_value / 10)) * 4.5), width, (int) (height - (max_value / 1000 - value / (max_value / 10)) * 4.6), width, 45);
        }

        ScreenHelper.drawTexture(getX(), getY(), width, height, FLUID_TANK_OVERLAY, false);

        if (mouseX >= getX() && mouseX <= getX() + width && mouseY >= getY() && mouseY <= getY() + height) {

            graphics.renderTooltip(Minecraft.getInstance().font, Component.literal(getMessage().getString() + " : " + value), mouseX, mouseY);
        }

    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }


}