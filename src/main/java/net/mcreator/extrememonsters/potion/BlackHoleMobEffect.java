
package net.mcreator.extrememonsters.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.procedures.BlackHoleOnEffectActiveTickProcedure;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.Set;

public class BlackHoleMobEffect extends MobEffect {
	public BlackHoleMobEffect() {
		super(MobEffectCategory.HARMFUL, -26113);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "effect.black_hole_0"), -0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "effect.black_hole_1"), -0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		BlackHoleOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
		return super.applyEffectTick(entity, amplifier);
	}
}
