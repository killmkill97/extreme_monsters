package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class NomalSmallFireBallTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
		if (immediatesourceentity.getPersistentData().getDouble("despawn") <= 100) {
			immediatesourceentity.getPersistentData().putDouble("despawn", (immediatesourceentity.getPersistentData().getDouble("despawn") + 1));
		}
		if (immediatesourceentity.getPersistentData().getDouble("despawn") > 100) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LAVA) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
	}
}
