package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.init.ExtremeMonstersModMobEffects;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.List;
import java.util.Comparator;

public class InfernoMatterBombProProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 100, 3, 3, 3, 0.1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.PLAYERS, 3, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.PLAYERS, 3, 1, false);
			}
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				ExtremeMonstersMod.queueServerWork(5, () -> {
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
						entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
					} else {
						entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
					}
					ExtremeMonstersMod.queueServerWork(5, () -> {
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
							entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
						} else {
							entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
						}
						ExtremeMonstersMod.queueServerWork(5, () -> {
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
								entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
							} else {
								entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
							}
							ExtremeMonstersMod.queueServerWork(5, () -> {
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
									entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
								} else {
									entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
								}
								ExtremeMonstersMod.queueServerWork(5, () -> {
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
										entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
									} else {
										entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
									}
									ExtremeMonstersMod.queueServerWork(5, () -> {
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
											entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
										} else {
											entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
										}
										ExtremeMonstersMod.queueServerWork(5, () -> {
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
												entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
											} else {
												entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
											}
											ExtremeMonstersMod.queueServerWork(5, () -> {
												ExtremeMonstersMod.queueServerWork(5, () -> {
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
														entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
													} else {
														entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
													}
													ExtremeMonstersMod.queueServerWork(5, () -> {
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
															entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
														} else {
															entityiterator.push((x * 0.08 - entityiterator.getX() * 0.08), (y * 0.08 - entityiterator.getY() * 0.08), (z * 0.08 - entityiterator.getZ() * 0.08));
														}
														ExtremeMonstersMod.queueServerWork(5, () -> {
															if (world instanceof ServerLevel _level)
																_level.sendParticles(ParticleTypes.FLASH, x, y, z, 5, 1, 1, 1, 1);
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			}
		}
		ExtremeMonstersMod.queueServerWork(5, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
				}
			}
			ExtremeMonstersMod.queueServerWork(5, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
					}
				}
				ExtremeMonstersMod.queueServerWork(5, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
						}
					}
					ExtremeMonstersMod.queueServerWork(5, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
							}
						}
						ExtremeMonstersMod.queueServerWork(5, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
								}
							}
							ExtremeMonstersMod.queueServerWork(5, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
									}
								}
								ExtremeMonstersMod.queueServerWork(5, () -> {
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
										}
									}
									ExtremeMonstersMod.queueServerWork(5, () -> {
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
											}
										}
										ExtremeMonstersMod.queueServerWork(5, () -> {
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
												}
											}
											ExtremeMonstersMod.queueServerWork(5, () -> {
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.WAX_ON, x, y, z, 50, 5, 5, 5, 1);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.MASTER, 1, 1, false);
													}
												}
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
		ExtremeMonstersMod.queueServerWork(50, () -> {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Mob) {
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
							entityiterator.push((entityiterator.getX() * 0.7 - x * 0.7), 1.2, (entityiterator.getZ() * 0.7 - z * 0.7));
						} else {
							entityiterator.push((entityiterator.getX() * 0.7 - x * 0.7), 1.2, (entityiterator.getZ() * 0.7 - z * 0.7));
						}
						entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:bomb_damage")))), 250);
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.MELT, 100, 4, false, false));
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.MASTER, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.MASTER, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 1, 0.1, 0.1, 0.1, 1);
		});
	}
}
