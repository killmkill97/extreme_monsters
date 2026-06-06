package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class MatterCatalystBoilerControllerTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double ws_x = 0;
		double ws_y = 0;
		double ws_z = 0;
		double oy = 0;
		double oz = 0;
		double ox = 0;
		double slot_loop = 0;
		double output_slot = 0;
		if (MatterCatalystBoilerMultiBlockVerificationProcedure.execute(world, x, y, z)) {
			if (world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z))) {
				ws_y = y - 3;
				oy = y - 3;
				if ((world.getBlockState(BlockPos.containing(x, y - 3, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_FLUID_INPUT_BLOCK.get()) {
					ws_x = x;
					ws_z = z - 1;
				} else if ((world.getBlockState(BlockPos.containing(x, y - 3, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_FLUID_INPUT_BLOCK.get()) {
					ws_x = x;
					ws_z = z + 1;
				} else if ((world.getBlockState(BlockPos.containing(x - 1, y - 3, z))).getBlock() == ExtremeMonstersModBlocks.DARK_FLUID_INPUT_BLOCK.get()) {
					ws_x = x - 1;
					ws_z = z;
				} else if ((world.getBlockState(BlockPos.containing(x + 1, y - 3, z))).getBlock() == ExtremeMonstersModBlocks.DARK_FLUID_INPUT_BLOCK.get()) {
					ws_x = x + 1;
					ws_z = z;
				}
				if ((world.getBlockState(BlockPos.containing(x, y - 3, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_ITEM_OUTPUT_BLOCK.get()) {
					ox = x;
					oz = z - 1;
				} else if ((world.getBlockState(BlockPos.containing(x, y - 3, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_ITEM_OUTPUT_BLOCK.get()) {
					ox = x;
					oz = z + 1;
				} else if ((world.getBlockState(BlockPos.containing(x - 1, y - 3, z))).getBlock() == ExtremeMonstersModBlocks.DARK_ITEM_OUTPUT_BLOCK.get()) {
					ox = x - 1;
					oz = z;
				} else if ((world.getBlockState(BlockPos.containing(x + 1, y - 3, z))).getBlock() == ExtremeMonstersModBlocks.DARK_ITEM_OUTPUT_BLOCK.get()) {
					ox = x + 1;
					oz = z;
				}
				if (new Object() {
					public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
						if (level instanceof ILevelExtension _ext) {
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
							if (_fluidHandler != null)
								return _fluidHandler.getFluidInTank(tank).getAmount();
						}
						return 0;
					}
				}.getFluidTankLevel(world, BlockPos.containing(ws_x, ws_y, ws_z), 1) >= 5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:reactor_buzzing")), SoundSource.BLOCKS, (float) 0.05, (float) 1.2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:reactor_buzzing")), SoundSource.BLOCKS, (float) 0.05, (float) 1.2, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.DUST_PLUME, (x + 0.5), (y - 1), (z + 0.5), 20, 0.8, 0.5, 0.8, 0.05);
					if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.ARTIFICIAL_NEUTRON_STAR.get()) {
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
								}.getValue(world, BlockPos.containing(x, y, z), "progress") + 500));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else {
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
								}.getValue(world, BlockPos.containing(x, y, z), "progress") + 250));
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
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == ExtremeMonstersModItems.SPEED_UPGRADE_1.get()) {
						if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.ARTIFICIAL_NEUTRON_STAR.get()) {
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
									}.getValue(world, BlockPos.containing(x, y, z), "progress") + 500));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else {
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
									}.getValue(world, BlockPos.containing(x, y, z), "progress") + 250));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
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
					}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == ExtremeMonstersModItems.SPEED_UPGRADE_2.get()) {
						if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.ARTIFICIAL_NEUTRON_STAR.get()) {
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
									}.getValue(world, BlockPos.containing(x, y, z), "progress") + 1000));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else {
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
									}.getValue(world, BlockPos.containing(x, y, z), "progress") + 500));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "progress") >= 1600) {
						if ((world.getBlockState(BlockPos.containing(ox, oy, oz))).getBlock() == ExtremeMonstersModBlocks.DARK_ITEM_OUTPUT_BLOCK.get()) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("progress", ((new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "progress")) - 1600));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (world instanceof ILevelExtension _ext) {
								IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(ws_x, ws_y, ws_z), null);
								if (_fluidHandler != null)
									_fluidHandler.drain(5, IFluidHandler.FluidAction.EXECUTE);
							}
							output_slot = FindOutputSlot2Procedure.execute(world, new ItemStack(ExtremeMonstersModBlocks.MATTER_CATALYST_FOUNDATION.get()), 64, 27, 0, ox, oy, oz);
							if (output_slot != -1) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(ox, oy, oz), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(ExtremeMonstersModBlocks.MATTER_CATALYST_FOUNDATION.get()).copy();
									_setstack.setCount((int) (new Object() {
										public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
											if (world instanceof ILevelExtension _ext) {
												IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
												if (_itemHandler != null)
													return _itemHandler.getStackInSlot(slotid).getCount();
											}
											return 0;
										}
									}.getAmount(world, BlockPos.containing(ox, oy, oz), (int) output_slot) + 1));
									_itemHandlerModifiable.setStackInSlot((int) output_slot, _setstack);
								}
							}
						} else {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.BLOCKS, (float) 0.2, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.BLOCKS, (float) 0.2, 1, false);
								}
							}
						}
					}
				}
			}
		}
	}
}
