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
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
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
import net.mcreator.extrememonsters.entity.HyperWitherWitherdDarkMatterClumpEntity;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperWitherAscentProjectileProcedure {
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
		double rz = 0;
		if (entity instanceof WitherBoss) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (entity.getPersistentData().getDouble("hyper_wither_ascentP") <= 0) {
						entity.getPersistentData().putDouble("hyper_wither_ascentP", 360);
					}
					if (entity.getPersistentData().getDouble("hyper_wither_ascentP") >= 0) {
						entity.getPersistentData().putDouble("hyper_wither_ascentP", (entity.getPersistentData().getDouble("hyper_wither_ascentP") - 1));
					}
					if (entity.getPersistentData().getDouble("hyper_wither_ascentP") <= 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.HOSTILE, (float) 0.2, 2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.HOSTILE, (float) 0.2, 2, false);
							}
						}
						new Object() {
							void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.HOSTILE, 1, 2);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.firecharge.use")), SoundSource.HOSTILE, 1, 2, false);
									}
								}
								entity.getPersistentData().putDouble("HyperWitherRx", (entity.getX() + Mth.nextDouble(RandomSource.create(), -10, 10)));
								entity.getPersistentData().putDouble("HyperWitherRz", (entity.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)));
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new HyperWitherWitherdDarkMatterClumpEntity(ExtremeMonstersModEntities.HYPER_WITHER_WITHERD_DARK_MATTER_CLUMP.get(), level) {
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
									_entityToSpawn.setPos((entity.getPersistentData().getDouble("HyperWitherRx")), (entity.getY()), (entity.getPersistentData().getDouble("HyperWitherRz")));
									_entityToSpawn.shoot(0, 1, 0, (float) 1.2, 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CLOUD, (entity.getPersistentData().getDouble("HyperWitherRx")), (entity.getY()), (entity.getPersistentData().getDouble("HyperWitherRz")), 50, 0.1, 0.05, 0.1, 0.1);
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
}
