package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.entity.NomalArrowEntity;
import net.mcreator.extrememonsters.entity.HomingArrowEntity;

import java.util.List;
import java.util.Comparator;

public class PerfectAbyssTickOnInvertoryProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		Entity target = null;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found_mob = false;
		boolean found = false;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("work")) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, x, y, z, 5, 0.5, 1, 0.5, 0);
			if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).perfect_abyss_despawn_mode) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Mob) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) 0.1);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLASH, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 2, 0.5, 1, 0.5, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.ASH, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 30, 0.5, 1, 0.5, 0.4);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.END_ROD, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 20, 0.5, 1, 0.5, 0.1);
								ParicleLaserFormSpawnProcedure.execute(world, x, y + 0.5, z, entityiterator.getX(), entityiterator.getY() + 0.5, entityiterator.getZ(), 0.1);
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
							}
						}
					}
				}
				sx = -12;
				for (int index0 = 0; index0 < 28; index0++) {
					sy = -12;
					for (int index1 = 0; index1 < 28; index1++) {
						sz = -12;
						for (int index2 = 0; index2 < 28; index2++) {
							if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.COBWEB) {
								world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CLOUD, (x + sx + 0.5), (y + sy + 0.5), (z + sz + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Mob) {
							if (!(entityiterator == entity)) {
								entityiterator.push((entityiterator.getX() * 0.1 - x * 0.1), (entityiterator.getY() * 0.1 - y * 0.1), (entityiterator.getZ() * 0.1 - z * 0.1));
								if (Math.random() <= 0.25) {
									ParicleLaserFormSpawnProcedure.execute(world, x, y + 0.5, z, entityiterator.getX(), entityiterator.getY() + 0.5, entityiterator.getZ(), 0.1);
								}
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Arrow || entityiterator instanceof HomingArrowEntity || entityiterator instanceof SpectralArrow || entityiterator instanceof NomalArrowEntity) {
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
