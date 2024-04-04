package com.st0x0ef.stellaris.common.data.planets;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.st0x0ef.stellaris.client.renderers.sky.PlanetSky;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

import net.minecraft.world.level.Level;

public record Planet(
        ResourceKey<Level> dimension,
        ResourceKey<Level> orbit,
        boolean oxygen,
        int temperature,
        int distanceFromEarth,
        float gravity,
        PlanetSky sky
) {
    public static final Codec<Planet> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceKey.codec(Registries.DIMENSION).fieldOf("level").forGetter(Planet::dimension),
            ResourceKey.codec(Registries.DIMENSION).fieldOf("orbit").forGetter(Planet::orbit),
            Codec.BOOL.fieldOf("oxygen").forGetter(Planet::oxygen),
            Codec.INT.fieldOf("temperature").forGetter(Planet::temperature),
            Codec.INT.fieldOf("distanceFromEarth").forGetter(Planet::distanceFromEarth),
            Codec.FLOAT.fieldOf("gravity").forGetter(Planet::gravity),
            PlanetSky.CODEC.fieldOf("sky").forGetter(Planet::sky)
    ).apply(instance, Planet::new));
}
