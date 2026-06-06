package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FoghornMagmaCubeProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof MagmaCube && (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS)
				? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue()
				: 0) == 1) {
			if ((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(ExtremeMonstersModAttributes.INVINCIBILITY)
					? _livingEntity2.getAttribute(ExtremeMonstersModAttributes.INVINCIBILITY).getBaseValue()
					: 0) == 0) {
				if (entity.getPersistentData().getDouble("invincibility") <= 0) {
					entity.getPersistentData().putDouble("invincibility", 200);
				}
				if (entity.getPersistentData().getDouble("invincibility") >= 0) {
					entity.getPersistentData().putDouble("invincibility", (entity.getPersistentData().getDouble("invincibility") - 1));
				}
				if (entity.getPersistentData().getDouble("invincibility") <= 0) {
					if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(ExtremeMonstersModAttributes.INVINCIBILITY))
						_livingEntity9.getAttribute(ExtremeMonstersModAttributes.INVINCIBILITY).setBaseValue(1);
				}
			}
			if ((entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(ExtremeMonstersModAttributes.INVINCIBILITY)
					? _livingEntity10.getAttribute(ExtremeMonstersModAttributes.INVINCIBILITY).getBaseValue()
					: 0) == 1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 5, 1, 1, 1, 0.3);
			}
		}
	}
}
