package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SimulationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		TrackerSimulationProcedure.execute(world, x, y, z);
		HyperZombieSiumlationProcedure.execute(world, x, y, z);
		HyperSkeletonSinulationProcedure.execute(world, x, y, z);
		HyperCreeperSimulationProcedure.execute(world, x, y, z);
		HyperSpiderSimulationProcedure.execute(world, x, y, z);
		HyperZombifiedPiglinSimulationProcedure.execute(world, x, y, z);
		HyperWitherSkeletonSImulationProcedure.execute(world, x, y, z);
		HyperBlazeSimulationProcedure.execute(world, x, y, z);
		HyperEndermanSimulationProcedure.execute(world, x, y, z);
		HyperMagmaCubeSimulationProcedure.execute(world, x, y, z);
	}
}
