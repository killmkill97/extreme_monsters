package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperBlazeDesignationProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (ExtremeMonstersConfigurationConfiguration.HYPER_MOB_SPAWN.get()) {
			if (ExtremeMonstersModVariables.MapVariables.get(world).Extreme) {
				if (entity instanceof Blaze) {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) Double.POSITIVE_INFINITY, 3, true, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) Double.POSITIVE_INFINITY, 1, true, false));
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
								_livingEntity6.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
							if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
								_livingEntity7.getAttribute(Attributes.MAX_HEALTH).setBaseValue(300);
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth(300);
						}
					}
				}
			}
		}
	}
}
