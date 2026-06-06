package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;

public class ReinforcedRedstoneBlockWorkProcedure {
	public static double execute(BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true) {
			return 15;
		}
		return 0;
	}
}
