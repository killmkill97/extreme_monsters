package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModEntities;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;
import net.mcreator.extrememonsters.entity.EndMeteorEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class HyperEnderDragonMeteorProcedure {
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
		boolean success = false;
		if (entity instanceof EnderDragon) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
				if (entity.getPersistentData().getDouble("end_meteor") <= 0) {
					entity.getPersistentData().putDouble("end_meteor", 500);
				}
				if (entity.getPersistentData().getDouble("end_meteor") >= 0) {
					entity.getPersistentData().putDouble("end_meteor", (entity.getPersistentData().getDouble("end_meteor") - 1));
				}
				if (entity.getPersistentData().getDouble("end_meteor") <= 0) {
					if (entity.isAlive()) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player) {
									success = true;
									for (int index0 = 0; index0 < 50; index0++) {
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
													AbstractArrow entityToSpawn = new EndMeteorEntity(ExtremeMonstersModEntities.END_METEOR.get(), level) {
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
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 5, 0, (byte) 0);
											_entityToSpawn.setPos((entityiterator.getX()), (entityiterator.getY() + 50), (entityiterator.getZ()));
											_entityToSpawn.shoot(0, 1, 0, 1, 50);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
								}
							}
						}
						if (success) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.HOSTILE, 5, (float) 0.75);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.HOSTILE, 5, (float) 0.75, false);
								}
							}
						}
					}
				}
			}
		}
	}
}
