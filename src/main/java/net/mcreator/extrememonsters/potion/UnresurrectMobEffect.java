
package net.mcreator.extrememonsters.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import java.util.Set;

public class UnresurrectMobEffect extends MobEffect {
	public UnresurrectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16711681);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}
}
