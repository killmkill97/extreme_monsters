package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.entity.WeakFlyingTrackerEntity;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

import java.util.UUID;

public class WeakFlyingTrackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		Entity target = null;
		if ((entity instanceof WeakFlyingTrackerEntity _datEntI ? _datEntI.getEntityData().get(WeakFlyingTrackerEntity.DATA_beaking_timer) : 0) < 60) {
			if (entity instanceof WeakFlyingTrackerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(WeakFlyingTrackerEntity.DATA_beaking_timer, (int) ((entity instanceof WeakFlyingTrackerEntity _datEntI ? _datEntI.getEntityData().get(WeakFlyingTrackerEntity.DATA_beaking_timer) : 0) + 1));
		}
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
				if ((entity instanceof WeakFlyingTrackerEntity _datEntI ? _datEntI.getEntityData().get(WeakFlyingTrackerEntity.DATA_beaking_timer) : 0) >= 60 && ExtremeMonstersConfigurationConfiguration.FLYING_TRACKER_BREAK_BLOCK.get()) {
					sx = -1;
					for (int index0 = 0; index0 < 3; index0++) {
						sy = -1;
						for (int index1 = 0; index1 < 3; index1++) {
							sz = -1;
							for (int index2 = 0; index2 < 3; index2++) {
								if (!(world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:cannot_broken_by_flying_tracker")))) {
									if (world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) != -1
											&& world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) < 45) {
										{
											BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
											Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + sx, y + sy, z + sz), null);
											world.destroyBlock(_pos, false);
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
}
