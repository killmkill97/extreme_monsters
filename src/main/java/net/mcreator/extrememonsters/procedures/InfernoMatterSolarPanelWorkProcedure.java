package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;

public class InfernoMatterSolarPanelWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		SolarPanelWorkBaseProcedure.execute(world, x, y, z, 15000);
	}
}
