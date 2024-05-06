package com.st0x0ef.stellaris.common.registry;

import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.common.blocks.FlagBlock;
import com.st0x0ef.stellaris.common.blocks.RadioactiveBlock;
import com.st0x0ef.stellaris.common.blocks.RocketLaunchPad;
import com.st0x0ef.stellaris.common.blocks.VerticalSlabBlock;
import com.st0x0ef.stellaris.common.blocks.machines.*;
import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class BlocksRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Stellaris.MODID, Registries.BLOCK);

    public static final RegistrySupplier<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(4.5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> IRON_PLATING_BLOCK = BLOCKS.register("iron_plating_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(4.5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> RAW_STEEL_BLOCK = BLOCKS.register("raw_steel_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> STEEL_PLANTING_BLOCK = BLOCKS.register("steel_planting_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> HEAVY_METAL_PLATE = BLOCKS.register("heavy_metal_plate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> HEAVY_METAL_CASING = BLOCKS.register("heavy_metal_casing", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> DESH_BLOCK = BLOCKS.register("desh_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> RAW_DESH_BLOCK = BLOCKS.register("raw_desh_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> DESH_PLANTING_BLOCK = BLOCKS.register("desh_plating_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> DESH_PILLAR = BLOCKS.register("desh_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> METEORITE = BLOCKS.register("meteorite", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> FLAG = BLOCKS.register("flag", () -> new FlagBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));


    /** Radioactivity */
    public static final RegistrySupplier<Block> MERCURY_URANIUM_ORE = BLOCKS.register("mercury_uranium_ore", () -> new RadioactiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops(), 1));
    public static final RegistrySupplier<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", () -> new RadioactiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(DyeColor.GREEN), 1));
    public static final RegistrySupplier<Block> RAW_URANIUM_BLOCK = BLOCKS.register("raw_uranium_block", () -> new RadioactiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).mapColor(DyeColor.GREEN), 1));
    public static final RegistrySupplier<Block> PLUTONIUM_BLOCK = BLOCKS.register("plutonium_block", () -> new RadioactiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(DyeColor.RED), 2));
    public static final RegistrySupplier<Block> NEPTUNIUM_BLOCK = BLOCKS.register("neptunium_block", () -> new RadioactiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(DyeColor.BLACK), 3));


    /** MARS Items */
    public static final RegistrySupplier<Block> CHISELED_MARS_STONE_BRICKS = BLOCKS.register("chiseled_mars_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CONGLOMORATE = BLOCKS.register("conglomorate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CRACKED_MARS_STONE_BRICKS = BLOCKS.register("cracked_mars_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_COBBLESONE = BLOCKS.register("mars_cobblestone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_IRON_ORE = BLOCKS.register("mars_iron_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_OSTRUM_ORE = BLOCKS.register("mars_ostrum_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_SAND = BLOCKS.register("mars_sand", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_STONE = BLOCKS.register("mars_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_STONE_BRICKS = BLOCKS.register("mars_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> POLISHED_CONGLOMORATE = BLOCKS.register("polished_conglomorate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> POLISHED_MARS_STONE = BLOCKS.register("polished_mars_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_STONE_BRICK_SLAB = BLOCKS.register("mars_stone_brick_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));

    /** MERCURY Items */
    public static final RegistrySupplier<Block> MERCURY_COBBLESTONE = BLOCKS.register("mercury_cobblestone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_IRON_ORE = BLOCKS.register("mercury_iron_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_STONE = BLOCKS.register("mercury_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_STONE_BRICKS = BLOCKS.register("mercury_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_STONE_PILLAR = BLOCKS.register("mercury_stone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CHISELED_MERCURY_STONE = BLOCKS.register("chiseled_mercury_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CRACKED_MERCURY_STONE_BRICKS = BLOCKS.register("cracked_mercury_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> POLISHED_MERCURY_STONE = BLOCKS.register("polished_mercury_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_STONE_BRICK_SLAB = BLOCKS.register("mercury_stone_brick_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));

    /** Venus Items */
    public static final RegistrySupplier<Block> CHISELED_VENUS_STONE = BLOCKS.register("chiseled_venus_stone", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CRACKED_VENUS_SANDSTONE_BRICKS = BLOCKS.register("cracked_venus_sandstone_bricks", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CRACKED_VENUS_STONE_BRICKS = BLOCKS.register("cracked_venus_stone_bricks", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> POLISHED_VENUS_STONE = BLOCKS.register("polished_venus_stone", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_COAL_ORE = BLOCKS.register("venus_coal_ore", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_COBBLESTONE = BLOCKS.register("venus_cobblestone", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_GOLD_ORE = BLOCKS.register("venus_gold_ore", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SAND = BLOCKS.register("venus_sand", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SANDSTONE = BLOCKS.register("venus_sandstone", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SANDSTONE_BRICKS = BLOCKS.register("venus_sandstone_bricks", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_STONE = BLOCKS.register("venus_stone", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_STONE_BRICKS = BLOCKS.register("venus_stone_bricks", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SMOOTH_SANDSTONE_BRICK = BLOCKS.register("venus_smooth_sandstone_brick", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_STONE_BRICK_SLAB = BLOCKS.register("venus_stone_brick_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SMOOTH_SANDSTONE = BLOCKS.register("venus_smooth_sandstone", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));

    /** Moon Items */
    public static final RegistrySupplier<Block> CHISELED_MOON_STONE = BLOCKS.register("chiseled_moon_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_COBBLESTONE = BLOCKS.register("moon_cobblestone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_SAND = BLOCKS.register("moon_sand", () -> new ColoredFallingBlock(new ColorRGBA(0x7E7E7E), BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.2f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_STONE = BLOCKS.register("moon_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_DEEPSLATE = BLOCKS.register("moon_deepslate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_STONE_DUST = BLOCKS.register("moon_stone_dust", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CRACKED_MOON_STONE_BRICKS = BLOCKS.register("cracked_moon_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_STONE_BRICKS = BLOCKS.register("moon_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_STONE_PILLAR = BLOCKS.register("moon_stone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> POLISHED_MOON_STONE = BLOCKS.register("polished_moon_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_DESH_ORE = BLOCKS.register("moon_desh_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_STONE_BRICK_SLAB = BLOCKS.register("moon_stone_brick_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_STONE_BRICK_STAIRS = BLOCKS.register("moon_stone_brick_stairs", () -> new StairBlock(MOON_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_POLISHED_STONE_BRICK_SLAB = BLOCKS.register("moon_polished_stone_brick_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_POLISHED_STONE_BRICK_STAIRS = BLOCKS.register("moon_polished_stone_brick_stairs", () -> new StairBlock(POLISHED_MOON_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> STEEL_ORE = BLOCKS.register("steel_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final RegistrySupplier<Block> DEEPSLATE_STEEL_ORE = BLOCKS.register("deepslate_steel_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofLegacyCopy(STEEL_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));

    public static final RegistrySupplier<RotatedPillarBlock> INFERNAL_SPIRE = BLOCKS.register("infernal_spire", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.5f, 1f).requiresCorrectToolForDrops()));

    /** Machine */
    public static final RegistrySupplier<Block> ROCKET_STATION = BLOCKS.register("rocket_station", () -> new RocketStation(BlockBehaviour.Properties.ofLegacyCopy(STEEL_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new BaseEnergyBlock(BlockBehaviour.Properties.of()));
    public static final RegistrySupplier<Block> SOLAR_PANEL = BLOCKS.register("solar_panel", () -> new SolarPanelBlock(BlockBehaviour.Properties.ofLegacyCopy(STEEL_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> COAL_GENERATOR = BLOCKS.register("coal_generator", () -> new CoalGenerator(BlockBehaviour.Properties.ofLegacyCopy(STEEL_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistrySupplier<Block> RADIOACTIVE_GENERATOR = BLOCKS.register("radioactive_generator", () -> new CoalGenerator(BlockBehaviour.Properties.ofLegacyCopy(STEEL_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));

    public static final RegistrySupplier<Block> ROCKET_LAUNCH_PAD = BLOCKS.register("rocket_launch_pad", () -> new RocketLaunchPad(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CABLE = BLOCKS.register("cable", ()-> new Cable(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)));
    public static final RegistrySupplier<Block> VACUMATOR = BLOCKS.register("vacumator", ()-> new Vacumator(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE)));
    public static final RegistrySupplier<Block> WATER_SEPARATOR = BLOCKS.register("water_separator", () -> new WaterSeparatorBlock(BlockBehaviour.Properties.ofLegacyCopy(STEEL_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3F).sound(SoundType.DEEPSLATE)));

    /**Fluid Blocks*/
    public static final RegistrySupplier<LiquidBlock> FUEL_BLOCK = BLOCKS.register("fuel", () -> new ArchitecturyLiquidBlock(FluidRegistry.FUEL_STILL, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final RegistrySupplier<LiquidBlock> OIL_BLOCK = BLOCKS.register("oil", () -> new ArchitecturyLiquidBlock(FluidRegistry.OIL_STILL, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final RegistrySupplier<LiquidBlock> HYDROGEN_BLOCK = BLOCKS.register("hydrogen", () -> new ArchitecturyLiquidBlock(FluidRegistry.HYDROGEN_STILL, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    public static final RegistrySupplier<Block> MERCURY_STONE_BRICK_STAIRS = BLOCKS.register("mercury_stone_brick_stairs", () -> new StairBlock(MERCURY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_STONE_BRICK_STAIRS = BLOCKS.register("mars_stone_brick_stairs", () -> new StairBlock(MARS_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_STONE_BRICK_STAIRS = BLOCKS.register("venus_stone_brick_stairs", () -> new StairBlock(VENUS_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));

    /**Globes*/
    public static final RegistrySupplier<Block> EARTH_GLOBE_BLOCK = BLOCKS.register("earth_globe", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5F).sound(SoundType.STONE).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_GLOBE_BLOCK = BLOCKS.register("moon_globe", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5F).sound(SoundType.STONE).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_GLOBE_BLOCK = BLOCKS.register("mars_globe", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5F).sound(SoundType.STONE).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_GLOBE_BLOCK = BLOCKS.register("mercury_globe", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5F).sound(SoundType.STONE).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_GLOBE_BLOCK = BLOCKS.register("venus_globe", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5F).sound(SoundType.STONE).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> CONGLOMORATE_STAIRS = BLOCKS.register("conglomorate_stairs", () -> new StairBlock(CONGLOMORATE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> IRON_PLATING_STAIRS = BLOCKS.register("iron_plating_stairs", () -> new StairBlock(IRON_PLATING_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_POLISHED_STONE_STAIRS = BLOCKS.register("mars_polished_stone_stairs", () -> new StairBlock(POLISHED_MARS_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_STONE_STAIRS = BLOCKS.register("mars_stone_stairs", () -> new StairBlock(MARS_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_POLISHED_STONE_STAIRS = BLOCKS.register("mercury_polished_stone_stairs", () -> new StairBlock(POLISHED_MERCURY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_STONE_STAIRS = BLOCKS.register("mercury_stone_stairs", () -> new StairBlock(MERCURY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_STONE_STAIRS = BLOCKS.register("moon_stone_stairs", () -> new StairBlock(MOON_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> POLISHED_CONGLOMORATE_STAIRS = BLOCKS.register("polished_conglomorate_stairs", () -> new StairBlock(POLISHED_CONGLOMORATE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_POLISHED_STONE_STAIRS = BLOCKS.register("venus_polished_stone_stairs", () -> new StairBlock(POLISHED_VENUS_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SANDSTONE_BRICKS_STAIRS = BLOCKS.register("venus_sandstone_brick_stairs", () -> new StairBlock(VENUS_SANDSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SMOOTH_SANDSTONE_BRICK_STAIRS = BLOCKS.register("venus_smooth_sandstone_brick_stairs", () -> new StairBlock(VENUS_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SMOOTH_SANDSTONE_STAIRS = BLOCKS.register("venus_smooth_sandstone_stairs", () -> new StairBlock(VENUS_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_STONE_STAIRS = BLOCKS.register("venus_stone_stairs", () -> new StairBlock(VENUS_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> STEEL_STAIRS = BLOCKS.register("steel_stairs", () -> new StairBlock(STEEL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> STEEL_PLANTING_STAIRS = BLOCKS.register("steel_planting_stairs", () -> new StairBlock(STEEL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> DESH_PLANTING_STAIRS = BLOCKS.register("desh_planting_stairs", () -> new StairBlock(STEEL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> HEAVY_METAL_STAIRS = BLOCKS.register("heavy_metal_stairs", () -> new StairBlock(HEAVY_METAL_PLATE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> CONGLOMORATE_SLAB = BLOCKS.register("conglomorate_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> IRON_PLATING_SLAB = BLOCKS.register("iron_plating_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_POLISHED_STONE_SLAB = BLOCKS.register("marcury_polished_stone_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MERCURY_STONE_SLAB = BLOCKS.register("marcury_stone_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_POLISHED_STONE_SLAB = BLOCKS.register("mars_polished_stone_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_STONE_SLAB = BLOCKS.register("mars_stone_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_STONE_SLAB = BLOCKS.register("moon_stone_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> POLISHED_CONGLOMORATE_SLAB = BLOCKS.register("polished_conglomorate_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SMOOTH_SANDSTONE_BRICK_SLAB = BLOCKS.register("venus_smooth_sandstone_brick_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SMOOTH_SANDSTONE_SLAB = BLOCKS.register("venus_smooth_sandstone_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_POLISHED_STONE_SLAB = BLOCKS.register("venus_polished_stone_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_SANDSTONE_BRICK_SLAB = BLOCKS.register("venus_sandstone_brick_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_STONE_SLAB = BLOCKS.register("venus_stone_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> HEAVY_METAL_SLAB = BLOCKS.register("heavy_metal_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> STEEL_SLAB = BLOCKS.register("steel_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> STEEL_PLANTING_SLAB = BLOCKS.register("steel_planting_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> DESH_PLANTING_SLAB = BLOCKS.register("desh_planting_slab", () -> new SlabBlock(SlabBlock.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> IRON_PILLAR = BLOCKS.register("iron_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MARS_PILLAR = BLOCKS.register("mars_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> MOON_PILLAR = BLOCKS.register("moon_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> STEEL_PILLAR = BLOCKS.register("steel_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> VENUS_PILLAR = BLOCKS.register("venus_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> VERTICAL_MOON_SLAB = BLOCKS.register("vertical_moon_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(5f, 2.5f).requiresCorrectToolForDrops()));

}
