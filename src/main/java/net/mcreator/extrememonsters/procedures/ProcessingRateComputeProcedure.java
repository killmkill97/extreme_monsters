package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ProcessingRateComputeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z, double constant1, double constant2) {
		double Q = 0;
		double S = 0;
		double a = 0;
		double b = 0;
		//P=clamp(100​+a*Q−b*S,100,1600) a,b는 상수
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
		a = constant1;
		b = constant2;
		return ClampToMcreatorProdProcedure.execute(100 + a * Q - b * S, 1600, 1);
	}
}
