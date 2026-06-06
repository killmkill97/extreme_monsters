package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class EnergyTotalAmountDisplayProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		double current_energy = 0;
		double total_energy = 0;
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get()) {
			total_energy = total_energy + new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getMaxEnergyStored();
					}
					return 0;
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x + 1, y + 4, z));
			current_energy = current_energy + new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x + 1, y + 4, z));
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get()) {
			total_energy = total_energy + new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getMaxEnergyStored();
					}
					return 0;
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x - 1, y + 4, z));
			current_energy = current_energy + new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x - 1, y + 4, z));
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 4, z + 1))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get()) {
			total_energy = total_energy + new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getMaxEnergyStored();
					}
					return 0;
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x, y + 4, z + 1));
			current_energy = current_energy + new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x, y + 4, z + 1));
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 4, z - 1))).getBlock() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get()) {
			total_energy = total_energy + new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getMaxEnergyStored();
					}
					return 0;
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x, y + 4, z - 1));
			current_energy = current_energy + new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x, y + 4, z - 1));
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_ENERGY_ACCEPTOR.get()) {
			total_energy = total_energy + new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getMaxEnergyStored();
					}
					return 0;
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x + 1, y + 4, z));
			current_energy = current_energy + new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x + 1, y + 4, z));
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_ENERGY_ACCEPTOR.get()) {
			total_energy = total_energy + new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getMaxEnergyStored();
					}
					return 0;
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x - 1, y + 4, z));
			current_energy = current_energy + new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x - 1, y + 4, z));
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 4, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_ENERGY_ACCEPTOR.get()) {
			total_energy = total_energy + new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getMaxEnergyStored();
					}
					return 0;
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x, y + 4, z + 1));
			current_energy = current_energy + new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x, y + 4, z + 1));
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 4, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_ENERGY_ACCEPTOR.get()) {
			total_energy = total_energy + new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getMaxEnergyStored();
					}
					return 0;
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x, y + 4, z - 1));
			current_energy = current_energy + new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x, y + 4, z - 1));
		}
		return new java.text.DecimalFormat("##.##").format(current_energy) + " / " + new java.text.DecimalFormat("##.##").format(total_energy);
	}
}
