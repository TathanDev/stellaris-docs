package com.st0x0ef.stellaris.client.screens.helper;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class ScreenHelper {

    public static class renderTextureWithColor {

        public static void blit(PoseStack stack, int p_93202_, int p_93203_, int p_93204_, int p_93205_, int p_93206_, TextureAtlasSprite p_93207_, Vec3 color) {
            innerBlit(stack.last().pose(), p_93202_, p_93202_ + p_93205_, p_93203_, p_93203_ + p_93206_, p_93204_, p_93207_.getU0(), p_93207_.getU1(), p_93207_.getV0(), p_93207_.getV1(), color);
        }

        public void blit(PoseStack stack, int p_93230_, int p_93231_, int blitOffset, int p_93232_, int p_93233_, int p_93234_, int p_93235_, Vec3 color) {
            blit(stack, p_93230_, p_93231_, blitOffset, (float)p_93232_, (float)p_93233_, p_93234_, p_93235_, 256, 256, color);
        }

        public static void blit(PoseStack stack, int p_93145_, int p_93146_, int p_93147_, float p_93148_, float p_93149_, int p_93150_, int p_93151_, int p_93152_, int p_93153_, Vec3 color) {
            innerBlit(stack, p_93145_, p_93145_ + p_93150_, p_93146_, p_93146_ + p_93151_, p_93147_, p_93150_, p_93151_, p_93148_, p_93149_, p_93152_, p_93153_, color);
        }

        public static void blit(PoseStack stack, int p_93162_, int p_93163_, int p_93164_, int p_93165_, float p_93166_, float p_93167_, int p_93168_, int p_93169_, int p_93170_, int p_93171_, Vec3 color) {
            innerBlit(stack, p_93162_, p_93162_ + p_93164_, p_93163_, p_93163_ + p_93165_, 0, p_93168_, p_93169_, p_93166_, p_93167_, p_93170_, p_93171_, color);
        }

        public static void blit(PoseStack stack, int p_93135_, int p_93136_, float p_93137_, float p_93138_, int p_93139_, int p_93140_, int p_93141_, int p_93142_, Vec3 color) {
            blit(stack, p_93135_, p_93136_, p_93139_, p_93140_, p_93137_, p_93138_, p_93139_, p_93140_, p_93141_, p_93142_, color);
        }

        private static void innerBlit(PoseStack stack, int p_93189_, int p_93190_, int p_93191_, int p_93192_, int p_93193_, int p_93194_, int p_93195_, float p_93196_, float p_93197_, int p_93198_, int p_93199_, Vec3 color) {
            innerBlit(stack.last().pose(), p_93189_, p_93190_, p_93191_, p_93192_, p_93193_, (p_93196_ + 0.0F) / (float)p_93198_, (p_93196_ + (float)p_93194_) / (float)p_93198_, (p_93197_ + 0.0F) / (float)p_93199_, (p_93197_ + (float)p_93195_) / (float)p_93199_, color);
        }

        private static void innerBlit(Matrix4f matrix4f, int x, int y, int p_93116_, int p_93117_, int p_93118_, float p_93119_, float p_93120_, float p_93121_, float p_93122_, Vec3 color) {


            int r = (int) color.x();
            int g = (int) color.y();
            int b = (int) color.z();

            RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
            BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR_TEX);
            bufferbuilder.vertex(matrix4f, (float)x, (float)p_93117_, (float)p_93118_).color(r, g, b, 255).uv(p_93119_, p_93122_).endVertex();
            bufferbuilder.vertex(matrix4f, (float)y, (float)p_93117_, (float)p_93118_).color(r, g, b, 255).uv(p_93120_, p_93122_).endVertex();
            bufferbuilder.vertex(matrix4f, (float)y, (float)p_93116_, (float)p_93118_).color(r, g, b, 255).uv(p_93120_, p_93121_).endVertex();
            bufferbuilder.vertex(matrix4f, (float)x, (float)p_93116_, (float)p_93118_).color(r, g, b, 255).uv(p_93119_, p_93121_).endVertex();
            BufferUploader.drawWithShader(bufferbuilder.end());
        }
    }

    public static class PlanetScreenHelper {
        public static final Component CATALOG_TEXT = tl("catalog");
        public static final Component BACK_TEXT = tl("back");

        public static final Component SOLAR_SYSTEM_TEXT = tl("solar_system");

        public static final Component PLANET_TEXT = tl("planet");
        public static final Component MOON_TEXT = tl("moon");

        public static final Component ORBIT_TEXT = tl("orbit");

        public static final Component NO_GRAVITY_TEXT = tl("no_gravity");

        public static final Component SPACE_STATION_TEXT = tl("space_station");

        public static final Component CATEGORY_TEXT = tl("category");
        public static final Component PROVIDED_TEXT = tl("provided");
        public static final Component TYPE_TEXT = tl("type");
        public static final Component GRAVITY_TEXT = tl("gravity");
        public static final Component OXYGEN_TEXT = tl("oxygen");
        public static final Component TEMPERATURE_TEXT = tl("temperature");
        public static final Component OXYGEN_TRUE_TEXT = tl("oxygen.true");
        public static final Component OXYGEN_FALSE_TEXT = tl("oxygen.false");
        public static final Component ITEM_REQUIREMENT_TEXT = tl("item_requirement");

        private static Component tl(String key) {
            return Component.translatable("stellaris.gui." + key);
        }



    }


    public static void drawTexture(int leftPos, int topPos, int width, int height, ResourceLocation texture, boolean blend) {
        if (blend) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
        }

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, texture);
        new GuiGraphics(Minecraft.getInstance(), Minecraft.getInstance().renderBuffers().bufferSource()).blit(texture, leftPos, topPos, 0, 0, width, height, width, height);

        if (blend) {
            RenderSystem.disableBlend();
        }
    }

}