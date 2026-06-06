package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModEntities;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;
import net.mcreator.extrememonsters.entity.HomingArrowEntity;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperSkeletonDefendArrowTickProcedure {
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
		if (entity instanceof Skeleton) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, x, y, z, 5, 0.5, 2, 0.5, 0.1);
				if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
					_livingEntity3.getAttribute(Attributes.MAX_HEALTH).setBaseValue(200);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1, false, false));
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (entity.getPersistentData().getDouble("arrow") <= 0) {
						entity.getPersistentData().putDouble("arrow", 200);
					}
					if (entity.getPersistentData().getDouble("arrow") >= 0) {
						entity.getPersistentData().putDouble("arrow", (entity.getPersistentData().getDouble("arrow") - 1));
					}
					if (entity.getPersistentData().getDouble("arrow") <= 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.MASTER, 15, 2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.MASTER, 15, 2, false);
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 99));
						for (int index0 = 0; index0 < 300; index0++) {
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new HomingArrowEntity(ExtremeMonstersModEntities.HOMING_ARROW.get(), level) {
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
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setSilent(true);
										entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, 10, 1, (byte) 0);
								_entityToSpawn.setPos(x, y, z);
								_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -3, 3)), (Mth.nextDouble(RandomSource.create(), -3, 3)), (Mth.nextDouble(RandomSource.create(), -3, 3)), 2, 3);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						ExtremeMonstersMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.MASTER, 15, 2);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.MASTER, 15, 2, false);
								}
							}
							for (int index1 = 0; index1 < 300; index1++) {
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new HomingArrowEntity(ExtremeMonstersModEntities.HOMING_ARROW.get(), level) {
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
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setSilent(true);
											entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, 10, 1, (byte) 0);
									_entityToSpawn.setPos(x, y, z);
									_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -3, 3)), (Mth.nextDouble(RandomSource.create(), -3, 3)), (Mth.nextDouble(RandomSource.create(), -3, 3)), 2, 3);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							ExtremeMonstersMod.queueServerWork(20, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.MASTER, 15, 2);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.MASTER, 15, 2, false);
									}
								}
								for (int index2 = 0; index2 < 300; index2++) {
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
												AbstractArrow entityToSpawn = new HomingArrowEntity(ExtremeMonstersModEntities.HOMING_ARROW.get(), level) {
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
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setSilent(true);
												entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, 10, 1, (byte) 0);
										_entityToSpawn.setPos(x, y, z);
										_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -3, 3)), (Mth.nextDouble(RandomSource.create(), -3, 3)), (Mth.nextDouble(RandomSource.create(), -3, 3)), 2, 3);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							});
						});
					}
				}
			}
		}
	}
}
