package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

public class InfernoMiningControllerTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack output = ItemStack.EMPTY;
		boolean work = false;
		double Efficiency = 0;
		double ox = 0;
		double oy = 0;
		double oz = 0;
		double check_slot = 0;
		if (MultiBlockVerificationProcedure.execute(world, x, y, z)) {
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getItem() == ExtremeMonstersModItems.FICTIONAL_PLANET_MODEL.get() && (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("depth") > 0) {
				if (world instanceof Level _level4 && _level4.hasNeighborSignal(BlockPos.containing(x, y, z))) {
					if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR) {
						world.setBlock(BlockPos.containing(x, y + 2, z), ExtremeMonstersModBlocks.FICTIONAL_PLANET.get().defaultBlockState(), 3);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.BLOCKS, (float) 0.6, (float) 1.1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.BLOCKS, (float) 0.6, (float) 1.1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
						ExtremeMonstersMod.queueServerWork(2, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
							ExtremeMonstersMod.queueServerWork(2, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
								ExtremeMonstersMod.queueServerWork(2, () -> {
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
									ExtremeMonstersMod.queueServerWork(2, () -> {
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
										ExtremeMonstersMod.queueServerWork(2, () -> {
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
											ExtremeMonstersMod.queueServerWork(2, () -> {
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
												ExtremeMonstersMod.queueServerWork(2, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
													ExtremeMonstersMod.queueServerWork(2, () -> {
														if (world instanceof ServerLevel _level)
															_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
														ExtremeMonstersMod.queueServerWork(2, () -> {
															if (world instanceof ServerLevel _level)
																_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
															ExtremeMonstersMod.queueServerWork(2, () -> {
																if (world instanceof ServerLevel _level)
																	_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 75, 0.4, 0.4, 0.4, 1);
															});
														});
													});
												});
											});
										});
									});
								});
							});
						});
					}
					if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get()) {
						if ((new Object() {
							public Direction getDirection(BlockState _bs) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp)
									return _bs.getValue(_dp);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
										? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
										: Direction.NORTH;
							}
						}.getDirection((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))))) == Direction.WEST) {
							world.addParticle(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 0.1, 0, 0);
							Efficiency = Efficiency + 1;
						}
					}
					if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get()) {
						if ((new Object() {
							public Direction getDirection(BlockState _bs) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp)
									return _bs.getValue(_dp);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
										? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
										: Direction.NORTH;
							}
						}.getDirection((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))))) == Direction.EAST) {
							world.addParticle(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), (-0.1), 0, 0);
							Efficiency = Efficiency + 1;
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get()) {
						if ((new Object() {
							public Direction getDirection(BlockState _bs) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp)
									return _bs.getValue(_dp);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
										? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
										: Direction.NORTH;
							}
						}.getDirection((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))))) == Direction.NORTH) {
							world.addParticle(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 0, 0, 0.1);
							Efficiency = Efficiency + 1;
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get()) {
						if ((new Object() {
							public Direction getDirection(BlockState _bs) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp)
									return _bs.getValue(_dp);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
										? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
										: Direction.NORTH;
							}
						}.getDirection((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))))) == Direction.SOUTH) {
							world.addParticle(ParticleTypes.END_ROD, (x + 0.5), (y + 2.5), (z + 0.5), 0, 0, (-0.1));
							Efficiency = Efficiency + 1;
						}
					}
					if (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							if (level instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
								if (_entityStorage != null)
									return _entityStorage.getEnergyStored();
							}
							return 0;
						}
					}.getEnergyStored(world, BlockPos.containing(x + 1, y + 4, z)) >= 75000) {
						if ((world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get()) {
							if (world instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x + 1, y + 4, z), null);
								if (_entityStorage != null)
									_entityStorage.extractEnergy((int) (75000 * Efficiency), false);
							}
							work = true;
						}
					} else if (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							if (level instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
								if (_entityStorage != null)
									return _entityStorage.getEnergyStored();
							}
							return 0;
						}
					}.getEnergyStored(world, BlockPos.containing(x - 1, y + 4, z)) >= 75000) {
						if ((world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get()) {
							if (world instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x - 1, y + 4, z), null);
								if (_entityStorage != null)
									_entityStorage.extractEnergy((int) (75000 * Efficiency), false);
							}
							work = true;
						}
					} else if (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							if (level instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
								if (_entityStorage != null)
									return _entityStorage.getEnergyStored();
							}
							return 0;
						}
					}.getEnergyStored(world, BlockPos.containing(x, y + 4, z + 1)) >= 75000) {
						if ((world.getBlockState(BlockPos.containing(x, y + 4, z + 1))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get()) {
							if (world instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y + 4, z + 1), null);
								if (_entityStorage != null)
									_entityStorage.extractEnergy((int) (75000 * Efficiency), false);
							}
							work = true;
						}
					} else if (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							if (level instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
								if (_entityStorage != null)
									return _entityStorage.getEnergyStored();
							}
							return 0;
						}
					}.getEnergyStored(world, BlockPos.containing(x, y + 4, z - 1)) >= 75000) {
						if ((world.getBlockState(BlockPos.containing(x, y + 4, z - 1))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get()) {
							if (world instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y + 4, z - 1), null);
								if (_entityStorage != null)
									_entityStorage.extractEnergy((int) (75000 * Efficiency), false);
							}
							work = true;
						}
					}
					if (work) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER, (x + 0.5), (y + 2.5), (z + 0.5), 10, 0.5, 0.5, 0.5, 0);
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
								}.getValue(world, BlockPos.containing(x, y, z), "progress") + 120 * Efficiency));
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
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == ExtremeMonstersModItems.SPEED_UPGRADE_1.get()) {
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
									}.getValue(world, BlockPos.containing(x, y, z), "progress") + 240 * Efficiency));
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
						}.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == ExtremeMonstersModItems.SPEED_UPGRADE_2.get()) {
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
									}.getValue(world, BlockPos.containing(x, y, z), "progress") + 360 * Efficiency));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("progress", 0);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if ((world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ITEM_OUTPUT_BLOCK.get()) {
								ox = x + 1;
								oy = y + 4;
								oz = z;
							} else if ((world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ITEM_OUTPUT_BLOCK.get()) {
								ox = x - 1;
								oy = y + 4;
								oz = z;
							} else if ((world.getBlockState(BlockPos.containing(x, y + 4, z + 1))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ITEM_OUTPUT_BLOCK.get()) {
								ox = x;
								oy = y + 4;
								oz = z + 1;
							} else if ((world.getBlockState(BlockPos.containing(x, y + 4, z - 1))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ITEM_OUTPUT_BLOCK.get()) {
								ox = x;
								oy = y + 4;
								oz = z - 1;
							} else {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.BLOCKS, (float) 0.1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.BLOCKS, (float) 0.1, 1, false);
									}
								}
								return;
							}
							output = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse((("extreme_monsters:fpm_depth_" + (new java.text.DecimalFormat("##").format((new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).copy();
									}
									return ItemStack.EMPTY;
								}
							}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("depth"))))).toLowerCase(java.util.Locale.ENGLISH))))
									.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
							if ((new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).copy();
									}
									return ItemStack.EMPTY;
								}
							}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rarity") > 0) {
								if (Math.random() <= (new Object() {
									public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
										if (world instanceof ILevelExtension _ext) {
											IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
											if (_itemHandler != null)
												return _itemHandler.getStackInSlot(slotid).copy();
										}
										return ItemStack.EMPTY;
									}
								}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rarity") * 0.005) {
									output = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("extreme_monsters:fpm_rarity_items"))).getRandomElement(RandomSource.create())
											.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
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
							}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == ExtremeMonstersModItems.SMELTING_UPGRADE.get()) {
								if (world instanceof Level _level102 && _level102.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(output), _level102).isPresent() && !(output.getItem() == Items.COAL)) {
									output = (world instanceof Level _lvlSmeltResult
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(output), _lvlSmeltResult).map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy())
													.orElse(ItemStack.EMPTY)
											: ItemStack.EMPTY).copy();
								}
							}
							for (int index0 = 0; index0 < 27; index0++) {
								if ((new Object() {
									public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
										if (world instanceof ILevelExtension _ext) {
											IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
											if (_itemHandler != null)
												return _itemHandler.getStackInSlot(slotid).copy();
										}
										return ItemStack.EMPTY;
									}
								}.getItemStack(world, BlockPos.containing(ox, oy, oz), (int) check_slot)).getItem() == Blocks.AIR.asItem()) {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(ox, oy, oz), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = output.copy();
										_setstack.setCount((int) (Mth.nextDouble(RandomSource.create(), 1, Mth.nextDouble(RandomSource.create(), 1, 1 + (new Object() {
											public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
												if (world instanceof ILevelExtension _ext) {
													IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
													if (_itemHandler != null)
														return _itemHandler.getStackInSlot(slotid).copy();
												}
												return ItemStack.EMPTY;
											}
										}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("density")))));
										_itemHandlerModifiable.setStackInSlot((int) check_slot, _setstack);
									}
									break;
								} else if ((new Object() {
									public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
										if (world instanceof ILevelExtension _ext) {
											IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
											if (_itemHandler != null)
												return _itemHandler.getStackInSlot(slotid).copy();
										}
										return ItemStack.EMPTY;
									}
								}.getItemStack(world, BlockPos.containing(ox, oy, oz), (int) check_slot)).getItem() == output.getItem() && new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										if (world instanceof ILevelExtension _ext) {
											IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
											if (_itemHandler != null)
												return _itemHandler.getStackInSlot(slotid).getCount();
										}
										return 0;
									}
								}.getAmount(world, BlockPos.containing(ox, oy, oz), (int) check_slot) < 64) {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(ox, oy, oz), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = output.copy();
										_setstack.setCount((int) ((new Object() {
											public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
												if (world instanceof ILevelExtension _ext) {
													IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
													if (_itemHandler != null)
														return _itemHandler.getStackInSlot(slotid).copy();
												}
												return ItemStack.EMPTY;
											}
										}.getItemStack(world, BlockPos.containing(ox, oy, oz), (int) check_slot)).getCount() + Mth.nextDouble(RandomSource.create(), 1, 1 + (new Object() {
											public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
												if (world instanceof ILevelExtension _ext) {
													IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
													if (_itemHandler != null)
														return _itemHandler.getStackInSlot(slotid).copy();
												}
												return ItemStack.EMPTY;
											}
										}.getItemStack(world, BlockPos.containing(x, y, z), 2)).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("density"))));
										_itemHandlerModifiable.setStackInSlot((int) check_slot, _setstack);
									}
									break;
								}
								check_slot = check_slot + 1;
							}
						}
					}
				} else {
					if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.FICTIONAL_PLANET.get()) {
						world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					}
				}
			} else {
				if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.FICTIONAL_PLANET.get()) {
					world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
				}
			}
		} else {
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.FICTIONAL_PLANET.get()) {
				world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
