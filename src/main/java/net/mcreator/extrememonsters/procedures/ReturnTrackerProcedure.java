package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.init.ExtremeMonstersModEntities;
import net.mcreator.extrememonsters.entity.TrackerEntity;

public class ReturnTrackerProcedure {
	public static Entity execute(LevelAccessor world) {
		return world instanceof Level _level ? new TrackerEntity(ExtremeMonstersModEntities.TRACKER.get(), _level) : null;
	}
}
