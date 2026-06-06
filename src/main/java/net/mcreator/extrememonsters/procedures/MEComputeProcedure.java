package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MEComputeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double RecTick = 0;
		double j = 0;
		double E = 0;
		//ME=1+j*E j는 상수
		E = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "errsov_count");
		j = 0.08;
		return 1 + j * E;
	}
}
