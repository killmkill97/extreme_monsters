package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModFluids;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FillWaterMCMProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (blockstate.getBlock() == ExtremeMonstersModBlocks.MATTER_CATALYST_MAKER.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
				if (new Object() {
					public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
						if (level instanceof ILevelExtension _ext) {
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
							if (_fluidHandler != null)
								return _fluidHandler.fill(new FluidStack(Fluids.WATER, amount), IFluidHandler.FluidAction.SIMULATE);
						}
						return 0;
					}
				}.fillTankSimulate(world, BlockPos.containing(x, y, z), 1000) >= 1000) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
						if (_fluidHandler != null)
							_fluidHandler.fill(new FluidStack(Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
					}
					ExtremeMonstersMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player)
							_player.closeContainer();
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.INFINITE_WATER_AMULET.get()) {
				if (world instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
					if (_fluidHandler != null)
						_fluidHandler.fill(new FluidStack(Fluids.WATER, new Object() {
							public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
								if (level instanceof ILevelExtension _ext) {
									IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
									if (_fluidHandler != null)
										return _fluidHandler.getTankCapacity(tank);
								}
								return 0;
							}
						}.getFluidTankCapacity(world, BlockPos.containing(x, y, z), 1)), IFluidHandler.FluidAction.EXECUTE);
				}
				ExtremeMonstersMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player)
						_player.closeContainer();
				});
			}
		}
		if (blockstate.getBlock() == ExtremeMonstersModBlocks.ICE_MAKER.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
				if (new Object() {
					public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
						if (level instanceof ILevelExtension _ext) {
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
							if (_fluidHandler != null)
								return _fluidHandler.fill(new FluidStack(Fluids.WATER, amount), IFluidHandler.FluidAction.SIMULATE);
						}
						return 0;
					}
				}.fillTankSimulate(world, BlockPos.containing(x, y, z), 1000) >= 1000) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
						if (_fluidHandler != null)
							_fluidHandler.fill(new FluidStack(Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
					}
					ExtremeMonstersMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player)
							_player.closeContainer();
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.INFINITE_WATER_AMULET.get()) {
				if (world instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
					if (_fluidHandler != null)
						_fluidHandler.fill(new FluidStack(Fluids.WATER, new Object() {
							public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
								if (level instanceof ILevelExtension _ext) {
									IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
									if (_fluidHandler != null)
										return _fluidHandler.getTankCapacity(tank);
								}
								return 0;
							}
						}.getFluidTankCapacity(world, BlockPos.containing(x, y, z), 1)), IFluidHandler.FluidAction.EXECUTE);
				}
				ExtremeMonstersMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player)
						_player.closeContainer();
				});
			}
		}
		if (blockstate.getBlock() == ExtremeMonstersModBlocks.DARK_FLUID_INPUT_BLOCK.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
				if (new Object() {
					public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
						if (level instanceof ILevelExtension _ext) {
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
							if (_fluidHandler != null)
								return _fluidHandler.fill(new FluidStack(Fluids.WATER, amount), IFluidHandler.FluidAction.SIMULATE);
						}
						return 0;
					}
				}.fillTankSimulate(world, BlockPos.containing(x, y, z), 1000) >= 1000) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
						if (_fluidHandler != null)
							_fluidHandler.fill(new FluidStack(Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
					}
					ExtremeMonstersMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player)
							_player.closeContainer();
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.INFINITE_WATER_AMULET.get()) {
				if (world instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
					if (_fluidHandler != null)
						_fluidHandler.fill(new FluidStack(Fluids.WATER, new Object() {
							public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
								if (level instanceof ILevelExtension _ext) {
									IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
									if (_fluidHandler != null)
										return _fluidHandler.getTankCapacity(tank);
								}
								return 0;
							}
						}.getFluidTankCapacity(world, BlockPos.containing(x, y, z), 1)), IFluidHandler.FluidAction.EXECUTE);
				}
				ExtremeMonstersMod.queueServerWork(1, () -> {
					if (entity instanceof Player _player)
						_player.closeContainer();
				});
			}
		}
		if (blockstate.getBlock() == ExtremeMonstersModBlocks.MOLECULAR_ASSEMBLER.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.MOLECULAR_SOLVENT_BUCKET.get()) {
				if (new Object() {
					public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
						if (level instanceof ILevelExtension _ext) {
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
							if (_fluidHandler != null)
								return _fluidHandler.fill(new FluidStack(ExtremeMonstersModFluids.MOLECULAR_SOLVENT.get(), amount), IFluidHandler.FluidAction.SIMULATE);
						}
						return 0;
					}
				}.fillTankSimulate(world, BlockPos.containing(x, y, z), 1000) >= 1000) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
						if (_fluidHandler != null)
							_fluidHandler.fill(new FluidStack(ExtremeMonstersModFluids.MOLECULAR_SOLVENT.get(), 1000), IFluidHandler.FluidAction.EXECUTE);
					}
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
			}
		}
	}
}
