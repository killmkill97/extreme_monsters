package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

public class DarkMatterGrowthAcceleratorTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (blockstate.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 250) {
				if (world instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
					if (_entityStorage != null)
						_entityStorage.extractEnergy(250, false);
				}
				if (ExtremeMonstersConfigurationConfiguration.MACHINE_PARTICLE.get()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1), (z + 0.5), 5, 0.25, 0.125, 0.2, 0);
				}
				sx = -10;
				found = false;
				for (int index0 = 0; index0 < 23; index0++) {
					sy = -10;
					for (int index1 = 0; index1 < 23; index1++) {
						sz = -10;
						for (int index2 = 0; index2 < 23; index2++) {
							if (!((world.getBlockState(BlockPos.containing(x + sz, y + sy, z + sx))).getBlock() == Blocks.GRASS_BLOCK) && !((world.getBlockState(BlockPos.containing(x + sz, y + sy, z + sx))).getBlock() == Blocks.WATER)) {
								if (world instanceof Level _level) {
									BlockPos _bp = BlockPos.containing(x + sz, y + sy, z + sx);
									if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
										if (!_level.isClientSide())
											_level.levelEvent(2005, _bp, 0);
									}
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
	}
}
