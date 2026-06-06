
package net.mcreator.extrememonsters.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.Set;

public class ExplosiveMobEffect extends MobEffect {
	public ExplosiveMobEffect() {
		super(MobEffectCategory.HARMFUL, -2744031);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "effect.explosive_0"), -0.5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}
}
