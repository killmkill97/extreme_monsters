package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
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
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

public class AdvancedMachineFrameAsseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean success = false;
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				if (world instanceof ILevelExtension _ext) {
					IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
					if (_itemHandler != null)
						return _itemHandler.getStackInSlot(slotid).copy();
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 6)).getItem() == ExtremeMonstersModBlocks.ADVANCED_MACHINE_FRAME.get().asItem() || (new Object() {
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
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).getCount();
					}
					return 0;
				}
			}.getAmount(world, BlockPos.containing(x, y, z), 6) < 64) {
				if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == ExtremeMonstersModBlocks.BASIC_MACHINE_FRAME.get().asItem()) {
					if ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == ExtremeMonstersModItems.DARK_MATTER.get()) {
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getItem() == Blocks.DIAMOND_BLOCK.asItem()) {
							if ((new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).copy();
									}
									return ItemStack.EMPTY;
								}
							}.getItemStack(world, BlockPos.containing(x, y, z), 3)).getItem() == ExtremeMonstersModItems.HYPER_GUNPOWDER.get()) {
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
										}.getValue(world, BlockPos.containing(x, y, z), "progress") + 5));
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
											}.getValue(world, BlockPos.containing(x, y, z), "progress") + 5));
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
											}.getValue(world, BlockPos.containing(x, y, z), "progress") + 10));
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
								}.getItemStack(world, BlockPos.containing(x, y, z), 7)).getItem() == ExtremeMonstersModItems.ASSEMBLER_UPGRADE_1.get()) {
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
											}.getValue(world, BlockPos.containing(x, y, z), "progress") + 40));
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
								}.getItemStack(world, BlockPos.containing(x, y, z), 7)).getItem() == ExtremeMonstersModItems.ASSEMBLER_UPGRADE_2.get()) {
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
											}.getValue(world, BlockPos.containing(x, y, z), "progress") + 80));
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
								}.getItemStack(world, BlockPos.containing(x, y, z), 7)).getItem() == ExtremeMonstersModItems.ASSEMBLER_UPGRADE_3.get()) {
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
											}.getValue(world, BlockPos.containing(x, y, z), "progress") + 640));
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
										_entityStorage.extractEnergy(150, false);
								}
								if (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "progress") >= 1600) {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = new ItemStack(ExtremeMonstersModBlocks.BASIC_MACHINE_FRAME.get()).copy();
										_setstack.setCount((int) (new Object() {
											public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
												if (world instanceof ILevelExtension _ext) {
													IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
													if (_itemHandler != null)
														return _itemHandler.getStackInSlot(slotid).getCount();
												}
												return 0;
											}
										}.getAmount(world, BlockPos.containing(x, y, z), 0) - 1));
										_itemHandlerModifiable.setStackInSlot(0, _setstack);
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.DARK_MATTER.get()).copy();
										_setstack.setCount((int) (new Object() {
											public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
												if (world instanceof ILevelExtension _ext) {
													IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
													if (_itemHandler != null)
														return _itemHandler.getStackInSlot(slotid).getCount();
												}
												return 0;
											}
										}.getAmount(world, BlockPos.containing(x, y, z), 1) - 1));
										_itemHandlerModifiable.setStackInSlot(1, _setstack);
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
										_setstack.setCount((int) (new Object() {
											public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
												if (world instanceof ILevelExtension _ext) {
													IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
													if (_itemHandler != null)
														return _itemHandler.getStackInSlot(slotid).getCount();
												}
												return 0;
											}
										}.getAmount(world, BlockPos.containing(x, y, z), 2) - 1));
										_itemHandlerModifiable.setStackInSlot(2, _setstack);
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.HYPER_GUNPOWDER.get()).copy();
										_setstack.setCount((int) (new Object() {
											public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
												if (world instanceof ILevelExtension _ext) {
													IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
													if (_itemHandler != null)
														return _itemHandler.getStackInSlot(slotid).getCount();
												}
												return 0;
											}
										}.getAmount(world, BlockPos.containing(x, y, z), 3) - 1));
										_itemHandlerModifiable.setStackInSlot(3, _setstack);
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = new ItemStack(ExtremeMonstersModBlocks.ADVANCED_MACHINE_FRAME.get()).copy();
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
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putDouble("progress", 0);
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
	}
}
