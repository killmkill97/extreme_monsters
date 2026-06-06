package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

public class AlloySmelterRecipeBaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack InputItem0, ItemStack InputItem1, ItemStack InputItem2, ItemStack InputItem3, ItemStack InputItem4, ItemStack InputItem5, ItemStack OutputItem, double DHFE,
			double UseEnergy) {
		boolean success = false;
		boolean FinalSuccess = false;
		double InputSlot = 0;
		double SuccessRate = 0;
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				if (world instanceof ILevelExtension _ext) {
					IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
					if (_itemHandler != null)
						return _itemHandler.getStackInSlot(slotid).copy();
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 6)).getItem() == OutputItem.getItem() && new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				if (world instanceof ILevelExtension _ext) {
					IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
					if (_itemHandler != null)
						return _itemHandler.getStackInSlot(slotid).getCount();
				}
				return 0;
			}
		}.getAmount(world, BlockPos.containing(x, y, z), 6) < OutputItem.getMaxStackSize() || (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				if (world instanceof ILevelExtension _ext) {
					IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
					if (_itemHandler != null)
						return _itemHandler.getStackInSlot(slotid).copy();
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 6)).getItem() == Blocks.AIR.asItem()) {
			if (new Object() {
				public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
					if (level instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
						if (_fluidHandler != null)
							return _fluidHandler.getFluidInTank(tank).getAmount();
					}
					return 0;
				}
			}.getFluidTankLevel(world, BlockPos.containing(x, y, z), 1) >= 1) {
				success = false;
				if (InputItem0.getItem() == Blocks.AIR.asItem()) {
					success = true;
				} else {
					success = FindEachItemProcedure.execute(world, InputItem0, 6, 0, x, y, z);
				}
				if (success) {
					SuccessRate = SuccessRate + 1;
				} //구분하기
				success = false;
				if (InputItem1.getItem() == Blocks.AIR.asItem()) {
					success = true;
				} else {
					success = FindEachItemProcedure.execute(world, InputItem1, 6, 0, x, y, z);
				}
				if (success) {
					SuccessRate = SuccessRate + 1;
				} //구분하기
				success = false;
				if (InputItem2.getItem() == Blocks.AIR.asItem()) {
					success = true;
				} else {
					success = FindEachItemProcedure.execute(world, InputItem2, 6, 0, x, y, z);
				}
				if (success) {
					SuccessRate = SuccessRate + 1;
				} //구분하기
				success = false;
				if (InputItem3.getItem() == Blocks.AIR.asItem()) {
					success = true;
				} else {
					success = FindEachItemProcedure.execute(world, InputItem3, 6, 0, x, y, z);
				}
				if (success) {
					SuccessRate = SuccessRate + 1;
				} //구분하기
				success = false;
				if (InputItem4.getItem() == Blocks.AIR.asItem()) {
					success = true;
				} else {
					success = FindEachItemProcedure.execute(world, InputItem4, 6, 0, x, y, z);
				}
				if (success) {
					SuccessRate = SuccessRate + 1;
				} //구분하기
				success = false;
				if (InputItem5.getItem() == Blocks.AIR.asItem()) {
					success = true;
				} else {
					success = FindEachItemProcedure.execute(world, InputItem5, 6, 0, x, y, z);
				}
				if (success) {
					SuccessRate = SuccessRate + 1;
				} //구분하기
				if (SuccessRate >= 6) {
					FinalSuccess = true;
				}
				if (FinalSuccess) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("progress", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "progress") + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 7)).getItem() == ExtremeMonstersModItems.SPEED_UPGRADE_1.get()) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("progress", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "progress") + 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 7)).getItem() == ExtremeMonstersModItems.SPEED_UPGRADE_2.get()) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("progress", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "progress") + 2));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (ExtremeMonstersConfigurationConfiguration.MACHINE_PARTICLE.get()) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1), (z + 0.5), 5, 0.25, 0.125, 0.2, 0);
					}
					if (world instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
						if (_entityStorage != null)
							_entityStorage.extractEnergy((int) UseEnergy, false);
					}
					RemoveHFEProcedure.execute(world, x, y, z, DHFE);
					if (world instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
						if (_fluidHandler != null)
							_fluidHandler.drain(1, IFluidHandler.FluidAction.EXECUTE);
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "progress") >= 1600) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("progress", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = OutputItem.copy();
							_setstack.setCount((int) (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).getCount();
									}
									return 0;
								}
							}.getAmount(world, BlockPos.containing(x, y, z), 6) + 1));
							_itemHandlerModifiable.setStackInSlot(6, _setstack);
						}
						if (!(InputItem0.getItem() == Blocks.AIR.asItem())) {
							InputSlot = FindItemSlotProcedure.execute(world, InputItem0, 6, 0, x, y, z);
							if (InputSlot != -1) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = (int) InputSlot;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(1);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
							}
						}
						if (!(InputItem1.getItem() == Blocks.AIR.asItem())) {
							InputSlot = FindItemSlotProcedure.execute(world, InputItem1, 6, 0, x, y, z);
							if (InputSlot != -1) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = (int) InputSlot;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(1);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
							}
						}
						if (!(InputItem2.getItem() == Blocks.AIR.asItem())) {
							InputSlot = FindItemSlotProcedure.execute(world, InputItem2, 6, 0, x, y, z);
							if (InputSlot != -1) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = (int) InputSlot;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(1);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
							}
						}
						if (!(InputItem3.getItem() == Blocks.AIR.asItem())) {
							InputSlot = FindItemSlotProcedure.execute(world, InputItem3, 6, 0, x, y, z);
							if (InputSlot != -1) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = (int) InputSlot;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(1);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
							}
						}
						if (!(InputItem4.getItem() == Blocks.AIR.asItem())) {
							InputSlot = FindItemSlotProcedure.execute(world, InputItem4, 6, 0, x, y, z);
							if (InputSlot != -1) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = (int) InputSlot;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(1);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
							}
						}
						if (!(InputItem5.getItem() == Blocks.AIR.asItem())) {
							InputSlot = FindItemSlotProcedure.execute(world, InputItem5, 6, 0, x, y, z);
							if (InputSlot != -1) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = (int) InputSlot;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(1);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
							}
						}
					}
				}
			}
		}
	}
}
