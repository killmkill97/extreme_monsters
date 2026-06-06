package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SuccessRateComputeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z, double constant1, double constant2) {
		double Q = 0;
		double S = 0;
		double c = 0;
		double d = 0;
		//SR=clamp(0.2+c*S−d*Q,0.01​,0.99) c,d는 상수
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
		c = constant1;
		d = constant2;
		return ClampToMcreatorProdProcedure.execute(0.2 + c * S - d * Q, 1, 0.01);
	}
}
