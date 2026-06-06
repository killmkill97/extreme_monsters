package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class QssMultiBlockStateReturnProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "right_position")) {
			if (world instanceof Level _level1 && _level1.hasNeighborSignal(BlockPos.containing(x, y, z))) {
				return "Activated";
			}
			return "Standby";
		}
		return "Worng position!";
	}
}
