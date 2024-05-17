package com.st0x0ef.stellaris.common.entities;

import com.st0x0ef.stellaris.common.menus.RocketMenu;
import com.st0x0ef.stellaris.common.registry.ParticleRegistry;
import com.st0x0ef.stellaris.common.registry.SoundRegistry;
import com.st0x0ef.stellaris.common.utils.PlanetUtil;
import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.architectury.registry.menu.MenuRegistry;
import io.netty.buffer.Unpooled;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RocketEntity extends IVehicleEntity implements ContainerListener, HasCustomInventoryScreen {


    public static final EntityDataAccessor<Integer> START_TIMER = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> ROCKET_START = SynchedEntityData.defineId(RocketEntity.class, EntityDataSerializers.BOOLEAN);

    protected SimpleContainer inventory;

    public RocketEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.entityData.set(START_TIMER, 0);
        this.entityData.set(ROCKET_START, false);

    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder
                .define(ROCKET_START, false)
                .define(START_TIMER, 0)
                .build();

    }

    @Override
    public void tick() {
        super.tick();

//        this.rotateRocket();
//        this.checkOnBlocks();
//        this.fillUpRocket();
//        this.rocketExplosion();
//        this.burnEntities();

        if (this.entityData.get(ROCKET_START)) {
            this.spawnParticle();
            this.startTimerAndFlyMovement();

            if (this.getY() > 600) {
                PlanetUtil.openPlanetSelectionMenu(this.getFirstPlayerPassenger());
            }
        }
    }


    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        this.getEntityData().set(ROCKET_START, compound.getBoolean("rocket_start"));
        this.getEntityData().set(START_TIMER, compound.getInt("start_timer"));


    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.put("InventoryCustom", this.inventory.createTag(this.registryAccess()));

        compound.putBoolean("rocket_start", this.getEntityData().get(ROCKET_START));
        compound.putInt("start_timer", this.getEntityData().get(START_TIMER));

    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public void push(Entity entity) {

    }
    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        super.interact(player, hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        if (!this.level().isClientSide) {
            if (player.isCrouching()) {
                this.openCustomInventoryScreen(player);
                return InteractionResult.CONSUME;
            }

            player.startRiding(this);
            return InteractionResult.CONSUME;
        }

        return result;
    }


    public double getRocketSpeed() {
        return Mth.clamp(0.65 * 1, 0.7, 1.5);
    }

    public void spawnParticle() {
        if (this.level() instanceof ServerLevel level) {
            Vec3 vec = this.getDeltaMovement();

            if (this.entityData.get(START_TIMER) == 200) {
                for (ServerPlayer player : level.getServer().getPlayerList().getPlayers()) {
                    level.sendParticles(player, (ParticleOptions) ParticleRegistry.LARGE_FLAME_PARTICLE.get(), true, this.getX() - vec.x, this.getY() - vec.y - 2.2, this.getZ() - vec.z, 20, 0.1, 0.1, 0.1, 0.001);
                    level.sendParticles(player, (ParticleOptions) ParticleRegistry.LARGE_SMOKE_PARTICLE.get(), true, this.getX() - vec.x, this.getY() - vec.y - 3.2, this.getZ() - vec.z, 10, 0.1, 0.1, 0.1, 0.04);
                }
            } else {
                for (ServerPlayer player : level.getServer().getPlayerList().getPlayers()) {
                    level.sendParticles(player, ParticleTypes.CAMPFIRE_COSY_SMOKE, true, this.getX() - vec.x, this.getY() - vec.y - 0.1, this.getZ() - vec.z, 6, 0.1, 0.1, 0.1, 0.023);
                }
            }
        }
    }

    public void startRocket() {
        Player player = (Player) this.getFirstPassenger();

        if (player != null) {
            SynchedEntityData data = this.getEntityData();

            //if (data.get(RocketEntity.FUEL) == this.getFuelCapacity()) {
                if (!data.get(RocketEntity.ROCKET_START)) {
                    data.set(RocketEntity.ROCKET_START, true);
                    this.level().playSound(null, this, SoundRegistry.ROCKET_SOUND.get(), SoundSource.NEUTRAL, 1, 1);
                    startTimerAndFlyMovement();
                }
            //} else {
            //    Methods.sendVehicleHasNoFuelMessage(player);
            //}
        }
    }


    public void startTimerAndFlyMovement() {
        if (this.entityData.get(START_TIMER) < 200) {
            this.entityData.set(START_TIMER, this.entityData.get(START_TIMER) + 1);
        }

        if (this.entityData.get(START_TIMER) == 200) {
            if (this.getDeltaMovement().y < this.getRocketSpeed() - 0.1) {
                this.setDeltaMovement(this.getDeltaMovement().x, this.getDeltaMovement().y + 0.1, this.getDeltaMovement().z);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().x, this.getRocketSpeed(), this.getDeltaMovement().z);
            }
        }
    }

    private void destroyRocket(boolean explode) {
        if (!this.level().isClientSide) {
            if (explode) {
                this.level().explode(this, this.getX(), this.getBoundingBox().maxY, this.getZ(), 10, true, Level.ExplosionInteraction.TNT);
            }
            this.remove(RemovalReason.DISCARDED);
        }
    }

    public Player getFirstPlayerPassenger() {
        if (!this.getPassengers().isEmpty() && this.getPassengers().getFirst() instanceof Player player) {
            return player;
        }

        return null;
    }

    @Override
    public void containerChanged(Container container) {

    }

    @Override
    public void openCustomInventoryScreen(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            MenuRegistry.openExtendedMenu(serverPlayer, new ExtendedMenuProvider() {
                @Override
                public void saveExtraData(FriendlyByteBuf packetByteBuf) {
                    packetByteBuf.writeInt(RocketEntity.this.getId());
                }

                @Override
                public Component getDisplayName() {
                    return Component.literal("Rocket");
                }

                @Override
                public AbstractContainerMenu createMenu(int syncId, Inventory inv, Player player) {
                    FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                    packetBuffer.writeVarInt(RocketEntity.this.getId());

                    return new RocketMenu(syncId, inv, packetBuffer);
                }
            });
        }
    }


}
