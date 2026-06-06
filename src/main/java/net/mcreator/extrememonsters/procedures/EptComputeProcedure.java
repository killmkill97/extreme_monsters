package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;

public class EptComputeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		//Ept=500000*ME*EEcore
		return 500000 * MEComputeProcedure.execute(world, x, y, z) * EECoreComputeProcedure.execute(world, x, y, z);
	}
}
