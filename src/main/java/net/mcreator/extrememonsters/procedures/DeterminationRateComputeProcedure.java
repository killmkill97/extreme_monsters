package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DeterminationRateComputeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double Q = 0;
		double S = 0;
		//DR=clamp(Round(4*(Q+1)*1.2/(1+Q)+(S+1)*0.75), 1, 5)
		S = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "stabil_count");
		Q = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "qubitmem_count");
		return ClampToMcreatorProdProcedure.execute(Math.round(4 * (((Q + 1) * 1.2) / (1 + Q + (S + 1) * 0.75))), 5, 1);
	}
}
