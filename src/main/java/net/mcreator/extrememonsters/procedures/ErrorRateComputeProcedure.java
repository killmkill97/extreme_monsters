package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ErrorRateComputeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z, double constant1, double constant2) {
		double Q = 0;
		double S = 0;
		double e = 0;
		double f = 0;
		//ER=clamp(0.02​+e*Q−f*S,0.0,0.95) e,f는 상수
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
		e = constant1;
		f = constant2;
		return ClampToMcreatorProdProcedure.execute(0.02 + e * Q - f * S, 0.95, 0);
	}
}
