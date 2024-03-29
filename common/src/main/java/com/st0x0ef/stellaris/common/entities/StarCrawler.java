package com.st0x0ef.stellaris.common.entities;

import com.st0x0ef.stellaris.common.registry.TagRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.level.Level;

public class StarCrawler extends Monster {
	public StarCrawler(EntityType<? extends Monster> type, Level world) {
		super(type, world);
		this.xpReward = 5;
	}

	public static AttributeSupplier.Builder setCustomAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.4)
				.add(Attributes.MAX_HEALTH, 40)
				.add(Attributes.ATTACK_DAMAGE, 9);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8, false));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.6));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return false;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource p_33034_) {
		return SoundEvents.TURTLE_HURT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return SoundEvents.TURTLE_DEATH;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof SpectralArrow)
			return false;
		if (source.getDirectEntity() instanceof Arrow)
			return false;
		return super.hurt(source, amount);
	}
	private boolean STAR_CRAWLER_SPAWN = true;
	@Override
	public void baseTick() {
		super.baseTick();
		if (!STAR_CRAWLER_SPAWN) {
			if (!this.level().isClientSide) {
				this.remove(RemovalReason.DISCARDED);
			}
		}
	}
}
