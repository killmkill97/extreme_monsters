package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class FindOutputSlot2Procedure {
	public static double execute(LevelAccessor world, ItemStack OutputItem, double MaxStack, double SlotLoop, double StartSlot, double pox, double poy, double poz) {
		ItemStack output = ItemStack.EMPTY;
		double ox = 0;
		double oy = 0;
		double oz = 0;
		double check_slot = 0;
		for (int index0 = 0; index0 < (int) SlotLoop; index0++) {
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(pox, poy, poz), (int) (check_slot + StartSlot))).getItem() == Blocks.AIR.asItem()) {
				return check_slot + StartSlot;
			} else if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(pox, poy, poz), (int) (check_slot + StartSlot))).getItem() == OutputItem.getItem() && new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).getCount();
					}
					return 0;
				}
			}.getAmount(world, BlockPos.containing(pox, poy, poz), (int) (check_slot + StartSlot)) < MaxStack) {
				return check_slot + StartSlot;
			}
			check_slot = check_slot + 1;
		}
		return -1;
	}
}
