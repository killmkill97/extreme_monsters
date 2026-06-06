package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class WorngPositionDisplayProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_MINING_CONTROLLER.get()) {
			if (MultiBlockVerificationProcedure.execute(world, x, y, z)) {
				if (world instanceof Level _level2 && _level2.hasNeighborSignal(BlockPos.containing(x, y, z))) {
					return "Activated";
				}
				return "Standby";
			}
			return "Invalid Structure!";
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CONTROLLER.get()) {
			if (DragonMultiBlockVerificationProcedure.execute(world, x, y, z)) {
				if (world instanceof Level _level5 && _level5.hasNeighborSignal(BlockPos.containing(x, y, z))) {
					return "Activated";
				}
				return "Standby";
			}
			return "Invalid Structure!";
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.MATTER_CATALYST_BOILER_CONTROLLER.get()) {
			if (MatterCatalystBoilerMultiBlockVerificationProcedure.execute(world, x, y, z)) {
				if (world instanceof Level _level8 && _level8.hasNeighborSignal(BlockPos.containing(x, y, z))) {
					return "Activated";
				}
				return "Standby";
			}
			return "Wrong Position!";
		}
		return "Invalid Structure!";
	}
}
