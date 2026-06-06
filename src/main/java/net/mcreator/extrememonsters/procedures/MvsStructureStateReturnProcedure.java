package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class MvsStructureStateReturnProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_SIMULATOR_CONTROLLER.get()) {
			if (MvsMultiBlockVerificationProcedure.execute(world, x, y, z)) {
				if (world instanceof Level _level2 && _level2.hasNeighborSignal(BlockPos.containing(x, y, z))) {
					return "Activated";
				}
				return "Standby";
			}
		}
		return "Invalid Structure!";
	}
}
