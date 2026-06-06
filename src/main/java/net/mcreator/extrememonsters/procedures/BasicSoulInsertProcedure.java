package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class BasicSoulInsertProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack paste_item = ItemStack.EMPTY;
		TrackersSoulInsertProcedure.execute(world, x, y, z);
		HyperZombiesSoulInsertProcedure.execute(world, x, y, z);
		HyperSkeletonsSoulInsertProcedure.execute(world, x, y, z);
		HyperCreepersSoulInsertProcedure.execute(world, x, y, z);
		HyperSpidersSoulInsertProcedure.execute(world, x, y, z);
		HyperZombifiedPiglinsSoulInsertProcedure.execute(world, x, y, z);
		HyperWitherSkeletonSoulInsertProcedure.execute(world, x, y, z);
		HyperBlazesSoulInsertProcedure.execute(world, x, y, z);
		HyperEndermanSoulInsertProcedure.execute(world, x, y, z);
		HyperMagmaCubesSoulInsertProcedure.execute(world, x, y, z);
		UltimateSoulInsertProcedure.execute(world, x, y, z);
		FictionalPlanetModelInsertProcedure.execute(world, x, y, z);
	}
}
