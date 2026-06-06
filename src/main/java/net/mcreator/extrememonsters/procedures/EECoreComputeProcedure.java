package net.mcreator.extrememonsters.procedures;

import org.checkerframework.checker.units.qual.h;
import org.checkerframework.checker.units.qual.g;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class EECoreComputeProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double Q = 0;
		double S = 0;
		double h = 0;
		double g = 0;
		//EEcore​=clamp(h*Q-g*S,100000​,6800000)
		//g,h는 상수
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
		h = 0.04;
		g = 0.03;
		return ClampToMcreatorProdProcedure.execute(1 + h * Q - g * S, 4, 1);
	}
}
