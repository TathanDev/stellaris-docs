package com.st0x0ef.stellaris.common.capabilities.oxygen;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.st0x0ef.stellaris.Stellaris;
import com.st0x0ef.stellaris.common.data.planets.Planet;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class OxygenProvider implements ICapabilityProvider, IOxygenStorageHolder {
    public static final Capability<OxygenStorage> OXYGEN = CapabilityManager.get(new CapabilityToken<>() {});
    public static final String KEY_OXYGEN = "Oxygen"; // for compatible other code

    private final ItemStack itemStack;
    private final IOxygenStorage oxygenStorage;

    public OxygenProvider(ItemStack itemStack, int capacity) {
        this.itemStack = itemStack;
        this.oxygenStorage = new OxygenStorage(this, capacity);

        this.readOxygen();
    }

    private void readOxygen() {
        CompoundTag compound = this.getItemStack().getOrCreateTag();
        this.getOxygenStorage().setOxygen(compound.getInt(KEY_OXYGEN));
    }

    public void writeOxygen() {
        CompoundTag compound = this.getItemStack().getOrCreateTag();
        compound.putInt(KEY_OXYGEN, this.getOxygenStorage().getOxygen());
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {
        LazyOptional<T> oxygenCapability = OxygenUtil.getOxygenCapability(capability, this::getOxygenStorage);

        if (oxygenCapability.isPresent()) {
            return oxygenCapability;
        }

        return LazyOptional.empty();
    }

    @Override
    public void onOxygenChanged(IOxygenStorage oxygenStorage, int oxygenDelta) {
        this.writeOxygen();
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public IOxygenStorage getOxygenStorage() {
        return this.oxygenStorage;
    }
}