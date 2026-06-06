package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModMobEffects;
import net.mcreator.extrememonsters.init.ExtremeMonstersModEntities;
import net.mcreator.extrememonsters.entity.TamableTrackerMeteorEntity;
import net.mcreator.extrememonsters.entity.TamableTrackerEntity;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class TamableTrackerTickProcedure {
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
		boolean explode = false;
		if (entity instanceof TamableTrackerEntity) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.getPersistentData().getDouble("ExplodeMob") < 10) {
					entity.getPersistentData().putDouble("ExplodeMob", (entity.getPersistentData().getDouble("ExplodeMob") + 1));
				}
				if (entity.getPersistentData().getDouble("ExplodeMob") >= 10) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								entity.getPersistentData().putDouble("ExplodeMob", 0);
								explode = true;
							}
						}
					}
					if (explode) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Mob && !(entityiterator instanceof TamableTrackerEntity) && !(entityiterator == entity)
										&& !(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
									entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:abyssal_damage")))), 6);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.EXPLOSIVE, 100, 1));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.MELT, 100, 0));
									if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
									entityiterator.push((entityiterator.getX() * 0.8 - x * 0.8), (entityiterator.getY() * 0.8 - y * 0.8), (entityiterator.getZ() * 0.8 - z * 0.8));
								}
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 1, 0, 0, 0, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, 2, (float) 1.2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, 2, (float) 1.2, false);
							}
						}
					}
				}
				if (entity.getPersistentData().getDouble("TrackerMeteor") < 300) {
					entity.getPersistentData().putDouble("TrackerMeteor", (entity.getPersistentData().getDouble("TrackerMeteor") + 1));
				}
				if (entity.getPersistentData().getDouble("TrackerMeteor") >= 300) {
					entity.getPersistentData().putDouble("TrackerMeteor", 0);
					new Object() {
						void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.HOSTILE, 1, 2);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.HOSTILE, 1, 2, false);
								}
							}
							entity.getPersistentData().putDouble("TrackerMeteorRx", (entity.getX() + Mth.nextDouble(RandomSource.create(), -10, 10)));
							entity.getPersistentData().putDouble("TrackerMeteorRz", (entity.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)));
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new TamableTrackerMeteorEntity(ExtremeMonstersModEntities.TAMABLE_TRACKER_METEOR.get(), level) {
											@Override
											public byte getPierceLevel() {
												return piercing;
											}

											@Override
											protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
												if (knockback > 0) {
													double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
													Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
													if (vec3.lengthSqr() > 0.0) {
														livingEntity.push(vec3.x, 0.1, vec3.z);
													}
												}
											}
										};
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setSilent(true);
										entityToSpawn.igniteForSeconds(100);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 5, 1, (byte) 0);
								_entityToSpawn.setPos((entity.getPersistentData().getDouble("TrackerMeteorRx")),
										(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("TrackerMeteorRx"), (int) entity.getPersistentData().getDouble("TrackerMeteorRz")) + 4),
										(entity.getPersistentData().getDouble("TrackerMeteorRz")));
								_entityToSpawn.shoot(0, 1, 0, (float) 1.2, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CLOUD, (entity.getPersistentData().getDouble("TrackerMeteorRx")),
										(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("TrackerMeteorRx"), (int) entity.getPersistentData().getDouble("TrackerMeteorRz")) + 4),
										(entity.getPersistentData().getDouble("TrackerMeteorRz")), 50, 0.1, 0.05, 0.1, 0.1);
							final int tick2 = ticks;
							ExtremeMonstersMod.queueServerWork(tick2, () -> {
								if (timedlooptotal > timedloopiterator + 1) {
									timedLoop(timedloopiterator + 1, timedlooptotal, tick2);
								}
							});
						}
					}.timedLoop(0, 20, 2);
				}
			}
		}
	}
}
