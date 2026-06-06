package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

public class QssChamberWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack output_item = ItemStack.EMPTY;
		double OutpuSlot = 0;
		double IoSlot = 0;
		double random_output_count = 0;
		double LoopSlot = 0;
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "QssProgress") >= 1600) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("QssProgress", ((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "QssProgress")) - 1600));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			for (int index0 = 0; index0 < 4; index0++) {
				if (!((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), (int) LoopSlot)).getItem() == Blocks.AIR.asItem())) {
					output_item = GetSoulItemProcedure.execute(new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), (int) LoopSlot)).copy();
					if ((500 - output_item.getDamageValue()) * 0.2 >= Mth.nextDouble(RandomSource.create(), 1, 100)) {
						if (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "QssSr") >= Math.random()) {
							random_output_count = Mth.nextDouble(RandomSource.create(), 1, new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "QssDr"));
							if (output_item.getItem() == ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()) {
								random_output_count = random_output_count * Mth.nextDouble(RandomSource.create(), 5, 20);
							}
							OutpuSlot = FindOutputSlot2Procedure.execute(world, output_item, 64, 27, 0, x, y - 2, z);
							if (OutpuSlot != -1) {
								if ((new Object() {
									public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
										if (world instanceof ILevelExtension _ext) {
											IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
											if (_itemHandler != null)
												return _itemHandler.getStackInSlot(slotid).copy();
										}
										return ItemStack.EMPTY;
									}
								}.getItemStack(world, BlockPos.containing(x, y - 2, z), (int) OutpuSlot)).getItem() == Blocks.AIR.asItem()) {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y - 2, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = output_item.copy();
										_setstack.setCount((int) random_output_count);
										_itemHandlerModifiable.setStackInSlot((int) OutpuSlot, _setstack);
									}
								} else {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y - 2, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = output_item.copy();
										_setstack.setCount((int) ((new Object() {
											public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
												if (world instanceof ILevelExtension _ext) {
													IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
													if (_itemHandler != null)
														return _itemHandler.getStackInSlot(slotid).copy();
												}
												return ItemStack.EMPTY;
											}
										}.getItemStack(world, BlockPos.containing(x, y - 2, z), (int) OutpuSlot)).getCount() + random_output_count));
										_itemHandlerModifiable.setStackInSlot((int) OutpuSlot, _setstack);
									}
								}
							}
						}
					}
				}
				LoopSlot = LoopSlot + 1;
			}
		}
	}
}
