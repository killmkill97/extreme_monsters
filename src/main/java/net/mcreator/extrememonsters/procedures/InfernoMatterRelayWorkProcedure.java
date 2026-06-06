package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;

public class InfernoMatterRelayWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double energy = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		HigherRelaySystemBaseProcedure.execute(world, x, y, z, 13, 4);
	}
}
