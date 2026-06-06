package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.entity.NomalArrowPlayerEntity;
import net.mcreator.extrememonsters.entity.NomalArrowEntity;
import net.mcreator.extrememonsters.entity.HomingArrowPlayerEntity;
import net.mcreator.extrememonsters.entity.HomingArrowEntity;

import java.util.List;
import java.util.Comparator;

public class ProjectileRemoveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
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
			}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 500) {
				if (world instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
					if (_entityStorage != null)
						_entityStorage.receiveEnergy(-500, false);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1), (z + 0.5), 5, 0.25, 0.125, 0.2, 0);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Arrow || entityiterator instanceof HomingArrowEntity || entityiterator instanceof SpectralArrow || entityiterator instanceof NomalArrowPlayerEntity || entityiterator instanceof NomalArrowEntity
								|| entityiterator instanceof HomingArrowPlayerEntity) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 5, 0.1, 0.1, 0.1, 0);
						}
					}
				}
			}
		}
	}
}
