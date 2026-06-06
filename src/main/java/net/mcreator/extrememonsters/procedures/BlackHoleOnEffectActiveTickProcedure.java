package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.extrememonsters.entity.TrackerEntity;
import net.mcreator.extrememonsters.entity.HyperTrackerEntity;
import net.mcreator.extrememonsters.entity.FlyingTrackerEntity;

import java.util.List;
import java.util.Comparator;

public class BlackHoleOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Mob) {
					if (!(entityiterator == entity) && !(entityiterator instanceof FlyingTrackerEntity) && !(entityiterator instanceof TrackerEntity) && !(entityiterator instanceof HyperTrackerEntity)) {
						entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
						if (Math.random() <= 0.2) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.INFESTED, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 2, 0.5, 1, 0.5, 0.4);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 2, 0.5, 1, 0.5, 0.1);
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Mob) {
					entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) (5 * amplifier));
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 10, 1, 1, 1, 0.1);
	}
}
