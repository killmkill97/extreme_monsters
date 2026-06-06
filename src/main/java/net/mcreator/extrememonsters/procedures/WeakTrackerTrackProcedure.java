package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.UUID;

public class WeakTrackerTrackProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
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
					_entity.getNavigation().moveTo((target.getX()), (target.getY()), (target.getZ()), 1.2);
			}
		}
	}
}
