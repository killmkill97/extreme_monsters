package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.init.ExtremeMonstersModEntities;
import net.mcreator.extrememonsters.entity.TrackerEntity;
import net.mcreator.extrememonsters.entity.SuperTrackerEntity;
import net.mcreator.extrememonsters.entity.FlyingTrackerEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class SuperTrackerTrackProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rx = 0;
		double ry = 0;
		double rz = 0;
		if (entity instanceof SuperTrackerEntity) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.getPersistentData().getDouble("ExplodePlayer") < 10) {
					entity.getPersistentData().putDouble("ExplodePlayer", (entity.getPersistentData().getDouble("ExplodePlayer") + 1));
				}
				if (entity.getPersistentData().getDouble("ExplodePlayer") >= 10) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (new Object() {
									public boolean checkGamemode(Entity _ent) {
										if (_ent instanceof ServerPlayer _serverPlayer) {
											return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
										} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
											return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
													&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
										}
										return false;
									}
								}.checkGamemode(entityiterator) || new Object() {
									public boolean checkGamemode(Entity _ent) {
										if (_ent instanceof ServerPlayer _serverPlayer) {
											return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
										} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
											return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
													&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
										}
										return false;
									}
								}.checkGamemode(entityiterator)) {
									entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 5);
									if (world instanceof Level _level && !_level.isClientSide())
										_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.MOB);
									entity.getPersistentData().putDouble("ExplodePlayer", 0);
									entityiterator.push((entityiterator.getX() * 0.8 - x * 0.8), (entityiterator.getY() * 0.8 - y * 0.8), (entityiterator.getZ() * 0.8 - z * 0.8));
								}
							}
						}
					}
				}
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {//트래커 소환
					if (entity.getPersistentData().getDouble("SummonTracker") < 417) {
						entity.getPersistentData().putDouble("SummonTracker", (entity.getPersistentData().getDouble("SummonTracker") + 1));
					}
					if (entity.getPersistentData().getDouble("SummonTracker") >= 417) {
						entity.getPersistentData().putDouble("SummonTracker", 0);
						for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 3, 6); index0++) {
							rx = x + Mth.nextDouble(RandomSource.create(), -4, 4);
							ry = y + Mth.nextDouble(RandomSource.create(), -4, 4);
							rz = z + Mth.nextDouble(RandomSource.create(), -4, 4);
							if ((world.getBlockState(BlockPos.containing(rx, ry, rz))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(rx, ry + 1, rz))).getBlock() == Blocks.AIR) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = ExtremeMonstersModEntities.TRACKER.get().spawn(_level, BlockPos.containing(rx, ry, rz), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
						for (int index1 = 0; index1 < (int) Mth.nextDouble(RandomSource.create(), 2, 4); index1++) {
							rx = x + Mth.nextDouble(RandomSource.create(), -4, 4);
							ry = y + Mth.nextDouble(RandomSource.create(), -4, 4);
							rz = z + Mth.nextDouble(RandomSource.create(), -4, 4);
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = ExtremeMonstersModEntities.FLYING_TRACKER.get().spawn(_level, BlockPos.containing(rx, ry, rz), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof TrackerEntity || entityiterator instanceof FlyingTrackerEntity) {
									entityiterator.setDeltaMovement(new Vec3((entityiterator.getX() * 0.4 - x * 0.4), (entityiterator.getY() * 0.4 - y * 0.4), (entityiterator.getZ() * 0.4 - z * 0.4)));
									entityiterator.getPersistentData().putString("target", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getStringUUID()));
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.OMINOUS_SPAWNING, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 50, 0.5, 0.5, 0.5, 0);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.HOSTILE, (float) 0.2, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.HOSTILE, (float) 0.2, 1, false);
							}
						}
					} //플레이어 끌어당기기
					if (entity.getPersistentData().getDouble("PullPlayer") < 302) {
						entity.getPersistentData().putDouble("PullPlayer", (entity.getPersistentData().getDouble("PullPlayer") + 1));
					}
					if (entity.getPersistentData().getDouble("PullPlayer") >= 302) {
						entity.getPersistentData().putDouble("PullPlayer", 0);
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player) {
									entityiterator.setDeltaMovement(new Vec3((x * 0.4 - entityiterator.getX() * 0.4), 0.4, (z * 0.4 - entityiterator.getZ() * 0.4)));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 50, 0.5, 0.5, 0.5, 0);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.HOSTILE, (float) 0.2, 2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.HOSTILE, (float) 0.2, 2, false);
							}
						}
					}
				}
			}
		}
	}
}
