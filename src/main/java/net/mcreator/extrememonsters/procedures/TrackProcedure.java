package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;

import java.util.UUID;
import java.util.List;
import java.util.Comparator;

public class TrackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		Entity target = null;
		if (new Object() {
			boolean isStringUUIDValid(String uuid) {
				boolean valid;
				try {
					UUID.fromString(uuid);
					valid = true;
				} catch (Exception e) {
					valid = false;
				}
				return valid;
			}
		}.isStringUUIDValid((entity.getPersistentData().getString("target")))) {
			if (!(new Object() {
				Entity entityFromStringUUID(String uuid, Level world) {
					Entity _uuidentity = null;
					if (world instanceof ServerLevel _server) {
						try {
							_uuidentity = _server.getEntity(UUID.fromString(uuid));
						} catch (Exception e) {
						}
					}
					return _uuidentity;
				}
			}.entityFromStringUUID((entity.getPersistentData().getString("target")), (Level) world) == null)) {
				target = new Object() {
					Entity entityFromStringUUID(String uuid, Level world) {
						Entity _uuidentity = null;
						if (world instanceof ServerLevel _server) {
							try {
								_uuidentity = _server.getEntity(UUID.fromString(uuid));
							} catch (Exception e) {
							}
						}
						return _uuidentity;
					}
				}.entityFromStringUUID((entity.getPersistentData().getString("target")), (Level) world);
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((target.getX()), (target.getY()), (target.getZ()), 1.1);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator == target) {
							if (!entity.level().isClientSide())
								entity.discard();
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 5);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.MOB);
						}
					}
				}
			}
		}
	}
}
