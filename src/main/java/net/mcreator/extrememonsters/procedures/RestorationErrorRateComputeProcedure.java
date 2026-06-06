package net.mcreator.extrememonsters.procedures;

import org.checkerframework.checker.units.qual.A;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class RestorationErrorRateComputeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double RecTick = 0;
		double A = 0;
		double E = 0;
		//Rec=RecTick/A*log10(E+1) A,RecTick는 상수
		RecTick = 80;
		E = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "errsov_count");
		A = 4;
		if (!(E == 0)) {
			return (int) Math.round(RecTick / (A * Math.log10(E + 1)));
		}
		return -1;
	}
}
