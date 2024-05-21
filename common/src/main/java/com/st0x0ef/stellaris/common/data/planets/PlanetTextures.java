package com.st0x0ef.stellaris.common.data.planets;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public record PlanetTextures(
        ResourceLocation planet_bar,
        ResourceLocation planet

) {
    public static final Codec<PlanetTextures> CODEC = RecordCodecBuilder.create(instance -> instance.group(

            ResourceLocation.CODEC.fieldOf("planet_bar").forGetter(PlanetTextures::planet_bar),
            ResourceLocation.CODEC.fieldOf("planet").forGetter(PlanetTextures::planet)


    ).apply(instance, PlanetTextures::new));

    public static PlanetTextures fromNetwork(FriendlyByteBuf buffer) {
        return new PlanetTextures(buffer.readResourceLocation(), buffer.readResourceLocation());
    }

    public void toNetwork(FriendlyByteBuf buffer) {
        buffer.writeResourceLocation(this.planet_bar);
        buffer.writeResourceLocation(this.planet);

    }
}
