package com.st0x0ef.stellaris.client.renderers.sky;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public record PlanetSky(
        ResourceKey<Level> dimension,
        boolean hasCloud,
        boolean hasFog,
        boolean hasRain,
        List<Float> sunriseColor,
        int stars,
        Optional<Float> starBrightness,
        WeightedRandomList<WeightedEntry.Wrapper<Integer>> starColors
) {

    public static final Codec<PlanetSky> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            ResourceKey.codec(Registries.DIMENSION).fieldOf("dimension").forGetter(PlanetSky::dimension),
            Codec.BOOL.fieldOf("has_clouds").forGetter(PlanetSky::hasCloud),
            Codec.BOOL.fieldOf("has_fog").forGetter(PlanetSky::hasFog),
            Codec.BOOL.fieldOf("has_rain").forGetter(PlanetSky::hasRain),
            Codec.FLOAT.listOf().fieldOf("sunrise_color").forGetter(PlanetSky::sunriseColor),
            Codec.INT.fieldOf("stars").forGetter(PlanetSky::stars),
            Codec.FLOAT.optionalFieldOf("star_brightness").forGetter(PlanetSky::starBrightness),
            SimpleWeightedRandomList.codec(WeightedEntry.Wrapper.codec(Codec.INT)).fieldOf("star_colors").forGetter(PlanetSky::starColors)
    ).apply(inst, PlanetSky::new));
}