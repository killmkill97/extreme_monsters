package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MobImmobilizationProcedure {
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
		if (entity.getPersistentData().getDouble("immobily_time") > 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.OMINOUS_SPAWNING, x, y, z, 25, 0.5, 0.5, 0.5, 0.1);
			entity.getPersistentData().putDouble("immobily_time", (entity.getPersistentData().getDouble("immobily_time") - 1));
			entity.push((entity.getPersistentData().getDouble("immobily_x") * 0.3 - entity.getX() * 0.3), (entity.getPersistentData().getDouble("immobily_y") * 0.3 - entity.getY() * 0.3),
					(entity.getPersistentData().getDouble("immobily_z") * 0.3 - entity.getZ() * 0.3));
		}
	}
}
