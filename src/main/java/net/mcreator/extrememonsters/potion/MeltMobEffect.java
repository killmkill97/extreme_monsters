
package net.mcreator.extrememonsters.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.procedures.MeltEffectProcedure;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.Set;

public class MeltMobEffect extends MobEffect {
	public MeltMobEffect() {
		super(MobEffectCategory.HARMFUL, -103);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "effect.melt_0"), -0.05, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "effect.melt_1"), -8, AttributeModifier.Operation.ADD_VALUE);
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
		MeltEffectProcedure.execute(entity.level(), entity, amplifier);
		return super.applyEffectTick(entity, amplifier);
	}
}
