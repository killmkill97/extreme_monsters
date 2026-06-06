package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.item.StasisRailGunItem;
import net.mcreator.extrememonsters.init.ExtremeMonstersModMobEffects;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class StasisRailGunUsePlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double scale = 0;
		if (entity.getPersistentData().getBoolean("EM_stasis_rail_gun_charging") && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.STASIS_RAIL_GUN.get()) {
			entity.getPersistentData().putDouble("EM_stasis_rail_gun_charging_tick", (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") + 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL, x, y, z, 4, 1, 1, 1, 0.2);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:reactor_buzzing")), SoundSource.PLAYERS,
							(float) (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") * 0.04 * 0.1), (float) (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") * 0.04));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:reactor_buzzing")), SoundSource.PLAYERS,
							(float) (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") * 0.04 * 0.1), (float) (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") * 0.04), false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_catalyst.bloom")), SoundSource.PLAYERS,
							(float) (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") * 0.04 * 0.1), (float) (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") * 0.04));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_catalyst.bloom")), SoundSource.PLAYERS,
							(float) (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") * 0.04 * 0.1), (float) (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") * 0.04), false);
				}
			}
			if (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") >= 50) {
				entity.getPersistentData().putBoolean("EM_stasis_rail_gun_charging", false);
				entity.getPersistentData().putDouble("EM_stasis_rail_gun_charging_tick", 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 1.5, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SCULK_SOUL, x, y, z, 150, 1, 1, 1, 0.2);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL, x, y, z, 150, 1, 1, 1, 0.4);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SCULK_CHARGE_POP, x, y, z, 50, 1, 1, 1, 0.2);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 40, 1, 1, 1, 0.2);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLASH, x, y, z, 2, 1, 1, 1, 0.2);
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
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(ExtremeMonstersModItems.STASIS_RAIL_GUN.get(), 300);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof StasisRailGunItem)
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString("geckoAnim", "animation.railgun.shoot"));
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * (-1.2)), 0.4, (entity.getLookAngle().z * (-1.2))));
				for (int index0 = 0; index0 < 500; index0++) {
					if (!world
							.getBlockState(new BlockPos(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
							.canOcclude()) {
						scale = scale + 0.8;
					} else {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SONIC_BOOM,
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getZ()),
									5, 0.5, 0.5, 0.5, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null,
										new BlockPos(
												entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX(),
												entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY(),
												entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()),
										BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.8, (float) 0.75);
							} else {
								_level.playLocalSound(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()),
										BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.8, (float) 0.75, false);
							}
						}
						{
							final Vec3 _center = new Vec3(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof EnderDragon) {
									if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 200) {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - 200));
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_dragon.hurt")), SoundSource.HOSTILE, 5, (float) 0.6);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_dragon.hurt")), SoundSource.HOSTILE, 5, (float) 0.6, false);
											}
										}
										entityiterator.getPersistentData().putDouble("immobily_x", (entityiterator.getX()));
										entityiterator.getPersistentData().putDouble("immobily_y", (entityiterator.getY()));
										entityiterator.getPersistentData().putDouble("immobily_z", (entityiterator.getZ()));
										entityiterator.getPersistentData().putDouble("immobily_time", 240);
										return;
									}
								} else if (entityiterator instanceof Mob) {
									entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 300);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.BLACK_HOLE, 300, 4));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.MELT, 300, 6));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.UNRESURRECT, 300, 0));
									entityiterator.getPersistentData().putDouble("immobily_x", (entityiterator.getX()));
									entityiterator.getPersistentData().putDouble("immobily_y", (entityiterator.getY()));
									entityiterator.getPersistentData().putDouble("immobily_z", (entityiterator.getZ()));
									entityiterator.getPersistentData().putDouble("immobily_time", 240);
								}
							}
						}
						break;
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS,
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								20, 0.1, 0.1, 0.1, 0.1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME,
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), 5,
								0.1, 0.1, 0.1, 0.1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.OMINOUS_SPAWNING,
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								15, 0.1, 0.1, 0.1, 0.1);
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scale)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof EnderDragon) {
								if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 200) {
									if (entityiterator instanceof LivingEntity _entity)
										_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - 200));
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_dragon.hurt")), SoundSource.HOSTILE, 5, (float) 0.6);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_dragon.hurt")), SoundSource.HOSTILE, 5, (float) 0.6, false);
										}
									}
									entityiterator.getPersistentData().putDouble("immobily_x", (entityiterator.getX()));
									entityiterator.getPersistentData().putDouble("immobily_y", (entityiterator.getY()));
									entityiterator.getPersistentData().putDouble("immobily_z", (entityiterator.getZ()));
									entityiterator.getPersistentData().putDouble("immobily_time", 240);
									return;
								}
							} else if (entityiterator instanceof Mob) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 300);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.BLACK_HOLE, 300, 2));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.MELT, 300, 4));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.UNRESURRECT, 300, 0));
								entityiterator.getPersistentData().putDouble("immobily_x", (entityiterator.getX()));
								entityiterator.getPersistentData().putDouble("immobily_y", (entityiterator.getY()));
								entityiterator.getPersistentData().putDouble("immobily_z", (entityiterator.getZ()));
								entityiterator.getPersistentData().putDouble("immobily_time", 240);
							}
						}
					}
				}
			}
		} else {
			if (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") > 0) {
				entity.getPersistentData().putDouble("EM_stasis_rail_gun_charging_tick", (entity.getPersistentData().getDouble("EM_stasis_rail_gun_charging_tick") - 1));
			}
		}
	}
}
