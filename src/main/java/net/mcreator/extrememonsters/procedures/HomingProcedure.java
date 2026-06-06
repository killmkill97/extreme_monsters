package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class HomingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Mob) {
					if (!(entityiterator == entity)) {
						immediatesourceentity.push((entityiterator.getX() * 0.1 - immediatesourceentity.getX() * 0.1), (entityiterator.getY() * 0.1 - immediatesourceentity.getY() * 0.1),
								(entityiterator.getZ() * 0.1 - immediatesourceentity.getZ() * 0.1));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FLAME, x, y, z, 1, 0.1, 0.1, 0.1, 0.1);
					}
				} else if (entityiterator instanceof Player) {
					immediatesourceentity.push((entityiterator.getX() * 0.1 - immediatesourceentity.getX() * 0.1), (entityiterator.getY() * 0.1 - immediatesourceentity.getY() * 0.1),
							(entityiterator.getZ() * 0.1 - immediatesourceentity.getZ() * 0.1));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLAME, x, y, z, 1, 0.1, 0.1, 0.1, 0.1);
				}
			}
		}
	}
}
