package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class DetectOtherItemsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5, ItemStack item6) {
		if (!(item1.getItem() == item2.getItem()) && !(item1.getItem() == item3.getItem()) && !(item1.getItem() == item4.getItem()) && !(item1.getItem() == item5.getItem()) && !(item1.getItem() == item6.getItem())) {
			if (!(item2.getItem() == item3.getItem()) && !(item2.getItem() == item4.getItem()) && !(item2.getItem() == item5.getItem()) && !(item2.getItem() == item6.getItem())) {
				if (!(item3.getItem() == item4.getItem()) && !(item3.getItem() == item5.getItem()) && !(item3.getItem() == item6.getItem())) {
					if (!(item4.getItem() == item5.getItem()) && !(item4.getItem() == item6.getItem())) {
						if (!(item5.getItem() == item6.getItem())) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putBoolean("allItemDifferent", true);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
				}
			}
		}
	}
}
