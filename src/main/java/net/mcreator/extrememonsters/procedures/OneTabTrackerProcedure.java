package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.entity.WeakTrackerEntity;
import net.mcreator.extrememonsters.entity.WeakFlyingTrackerEntity;
import net.mcreator.extrememonsters.entity.TrackerEntity;
import net.mcreator.extrememonsters.entity.FlyingTrackerEntity;

public class OneTabTrackerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FlyingTrackerEntity || entity instanceof TrackerEntity) {
			if (!entity.level().isClientSide())
				entity.discard();
			ExplodeProcedure.execute(world, x, y, z, entity);
		} else if (entity instanceof WeakTrackerEntity || entity instanceof WeakFlyingTrackerEntity) {
			if (!entity.level().isClientSide())
				entity.discard();
			WeakExplodeTrackersProcedure.execute(world, x, y, z, entity);
		}
	}
}
