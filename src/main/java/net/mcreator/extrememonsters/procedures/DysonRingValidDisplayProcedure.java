package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DysonRingValidDisplayProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if (DysonRingMultiBlockVerificationProcedure.execute(world, x, y, z)) {
			if (new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "ignited")) {
				return "Activated";
			}
			return "Standby";
		}
		return "Invalid Structure!";
	}
}
