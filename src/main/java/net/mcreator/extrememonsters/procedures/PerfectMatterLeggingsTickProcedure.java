package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.extrememonsters.init.ExtremeMonstersModMobEffects;

public class PerfectMatterLeggingsTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.LONG_REACH, 10, 3, false, false));
	}
}
