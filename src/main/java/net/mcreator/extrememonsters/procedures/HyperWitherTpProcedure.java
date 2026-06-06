package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModEntities;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;
import net.mcreator.extrememonsters.entity.WitheredDarkMatterEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperWitherTpProcedure {
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
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 5, 0.5, 2, 0.5, 0.1);
				if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.ARMOR))
					_livingEntity3.getAttribute(Attributes.ARMOR).setBaseValue(30);
				if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
					_livingEntity4.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(30);
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (entity.getPersistentData().getDouble("hyper_wither_tp") <= 0) {
						entity.getPersistentData().putDouble("hyper_wither_tp", 200);
					}
					if (entity.getPersistentData().getDouble("hyper_wither_tp") >= 0) {
						entity.getPersistentData().putDouble("hyper_wither_tp", (entity.getPersistentData().getDouble("hyper_wither_tp") - 1));
					}
					if (entity.getPersistentData().getDouble("hyper_wither_tp") <= 0) {
						rx = x + Mth.nextInt(RandomSource.create(), -10, 10);
						rz = z + Mth.nextInt(RandomSource.create(), -10, 10);
						if ((world.getBlockState(BlockPos.containing(rx, y + 1, rz))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(rx, y, rz))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(rx, y - 1, rz))).getBlock() == Blocks.AIR) {
							for (int index0 = 0; index0 < 100; index0++) {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
												AbstractArrow entityToSpawn = new WitheredDarkMatterEntity(ExtremeMonstersModEntities.WITHERED_DARK_MATTER.get(), level) {
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
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 20, 1, (byte) 0);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.1, 999);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							}
							{
								Entity _ent = entity;
								_ent.teleportTo(rx, y, rz);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(rx, y, rz, _ent.getYRot(), _ent.getXRot());
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 0.5, 1, 0.5, 0.2);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLAME, rx, y, rz, 20, 0.5, 1, 0.5, 0.2);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLASH, rx, y, rz, 2, 0.5, 1, 0.5, 0.2);
						}
					}
				}
			}
		}
	}
}
