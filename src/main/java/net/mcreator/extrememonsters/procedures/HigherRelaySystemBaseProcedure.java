package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class HigherRelaySystemBaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double CubeSize, double Divided) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double energy = 0;
		sx = (CubeSize - 1) / (-2);
		for (int index0 = 0; index0 < (int) CubeSize; index0++) {
			sy = (CubeSize - 1) / (-2);
			for (int index1 = 0; index1 < (int) CubeSize; index1++) {
				sz = (CubeSize - 1) / (-2);
				for (int index2 = 0; index2 < (int) CubeSize; index2++) {
					if (new Object() {
						public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
							if (level instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
								if (_entityStorage != null)
									return _entityStorage.canReceive();
							}
							return false;
						}
					}.canReceiveEnergy(world, BlockPos.containing(x + sx, y + sy, z + sz)) && !(world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:accept_disabled")))) {
						energy = new Object() {
							public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
								if (level instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
									if (_entityStorage != null)
										return _entityStorage.receiveEnergy(_amount, true);
								}
								return 0;
							}
						}.receiveEnergySimulate(world, BlockPos.containing(x + sx, y + sy, z + sz), (int) (new Object() {
							public int getEnergyStored(LevelAccessor level, BlockPos pos) {
								if (level instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
									if (_entityStorage != null)
										return _entityStorage.getEnergyStored();
								}
								return 0;
							}
						}.getEnergyStored(world, BlockPos.containing(x, y, z)) / Divided));
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy((int) energy, false);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x + sx, y + sy, z + sz), null);
							if (_entityStorage != null)
								_entityStorage.receiveEnergy((int) energy, false);
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
