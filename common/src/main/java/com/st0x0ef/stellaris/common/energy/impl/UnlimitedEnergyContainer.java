package com.st0x0ef.stellaris.common.energy.impl;


import com.st0x0ef.stellaris.common.energy.base.EnergyContainer;
import com.st0x0ef.stellaris.common.energy.base.EnergySnapshot;
import com.st0x0ef.stellaris.common.energy.util.Updatable;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;

public class UnlimitedEnergyContainer implements EnergyContainer, Updatable {
    @Override
    public long insertEnergy(long maxAmount, boolean simulate) {
        return 0;
    }

    @Override
    public long extractEnergy(long maxAmount, boolean simulate) {
        return Integer.MAX_VALUE;
    }

    @Override
    public void setEnergy(long energy) {
        // do nothing
    }

    @Override
    public long getStoredEnergy() {
        return Integer.MAX_VALUE;
    }

    @Override
    public long getMaxEnergyStored() {
        return Integer.MAX_VALUE;
    }

    @Override
    public long getMaxCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public long maxInsert() {
        return 0;
    }

    @Override
    public long maxExtract() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean allowsInsertion() {
        return false;
    }

    @Override
    public boolean allowsExtraction() {
        return true;
    }

    @Override
    public EnergySnapshot createSnapshot() {
        return new SimpleEnergySnapshot(this);
    }

    @Override
    public void deserialize(CompoundTag nbt, HolderLookup.Provider provider) {
        // do nothing
    }

    @Override
    public CompoundTag serialize(CompoundTag nbt, HolderLookup.Provider provider) {
        return nbt;
    }

    @Override
    public void update() {
        // do nothing
    }

    @Override
    public void clearContent() {
        // do nothing
    }
}
