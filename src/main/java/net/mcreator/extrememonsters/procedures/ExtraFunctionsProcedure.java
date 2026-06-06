package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModEntities;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;
import net.mcreator.extrememonsters.entity.WaterPelletEntity;
import net.mcreator.extrememonsters.entity.PlyerWitheredDarkMatterMainEntity;
import net.mcreator.extrememonsters.entity.LavaPelletEntity;
import net.mcreator.extrememonsters.entity.GriefingPlayerWitheredDarkMatterMainEntity;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class ExtraFunctionsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found_mob = false;
		boolean success = false;
		Entity target = null;
		ItemStack item = ItemStack.EMPTY;
		ItemStack paste_item = ItemStack.EMPTY;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			if (item.getItem() == ExtremeMonstersModItems.DARK_MATTER_SWORD.get()) {
				if (!(entity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(item.getItem(), 15);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Mob) {
								if (!(entityiterator instanceof Blaze || entityiterator instanceof WitherSkeleton)) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 9);
									found_mob = true;
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
										if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							}
						}
					}
					sx = -3;
					for (int index0 = 0; index0 < 7; index0++) {
						sy = -3;
						for (int index1 = 0; index1 < 7; index1++) {
							sz = -3;
							for (int index2 = 0; index2 < 7; index2++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.COBWEB) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									found_mob = true;
									world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.CLOUD, (x + sx + 0.5), (y + sy + 0.5), (z + sz + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found_mob) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
							}
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.INFERNO_MATTER_SWORD.get()) {
				if (!(entity instanceof Player _plrCldCheck22 && _plrCldCheck22.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(item.getItem(), 10);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Mob) {
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 13);
								found_mob = true;
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
									if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
								}
							}
						}
					}
					sx = -5;
					for (int index3 = 0; index3 < 13; index3++) {
						sy = -5;
						for (int index4 = 0; index4 < 13; index4++) {
							sz = -5;
							for (int index5 = 0; index5 < 13; index5++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.COBWEB) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									found_mob = true;
									world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.CLOUD, (x + sx + 0.5), (y + sy + 0.5), (z + sz + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found_mob) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
							}
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.DRAGON_MATTER_SWORD.get()) {
				if (!(entity instanceof Player _plrCldCheck39 && _plrCldCheck39.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(item.getItem(), 10);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(35 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).slash_all) {
								if (entityiterator instanceof Mob) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:abyssal_damage")))), 18);
									found_mob = true;
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2));
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
										if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							} else {
								if (entityiterator instanceof Monster) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:abyssal_damage")))), 18);
									found_mob = true;
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2));
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
										if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							}
						}
					}
					sx = -7;
					for (int index6 = 0; index6 < 17; index6++) {
						sy = -7;
						for (int index7 = 0; index7 < 17; index7++) {
							sz = -7;
							for (int index8 = 0; index8 < 17; index8++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.COBWEB) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									found_mob = true;
									world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.CLOUD, (x + sx + 0.5), (y + sy + 0.5), (z + sz + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found_mob) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
							}
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.WITHER_MATTER_SWORD.get()) {
				if (!(entity instanceof Player _plrCldCheck67 && _plrCldCheck67.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(item.getItem(), 8);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).slash_all) {
								if (entityiterator instanceof Mob) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:abyssal_damage")))), 24);
									found_mob = true;
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 4));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2));
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
										if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							} else {
								if (entityiterator instanceof Monster) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:abyssal_damage")))), 24);
									found_mob = true;
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 4));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2));
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
										if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							}
						}
					}
					sx = -10;
					for (int index9 = 0; index9 < 24; index9++) {
						sy = -10;
						for (int index10 = 0; index10 < 24; index10++) {
							sz = -10;
							for (int index11 = 0; index11 < 24; index11++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.COBWEB) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									found_mob = true;
									world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.CLOUD, (x + sx + 0.5), (y + sy + 0.5), (z + sz + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found_mob) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
							}
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.PERFECT_MATTER_SWORD.get()) {
				if (!(entity instanceof Player _plrCldCheck97 && _plrCldCheck97.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(item.getItem(), 2);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).slash_all) {
								if (entityiterator instanceof Mob) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:abyssal_damage")))), 99999);
									found_mob = true;
									ExtremeMonstersMod.queueServerWork(2, () -> {
										{
											Entity _ent = entityiterator;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill");
											}
										}
									});
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
										if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							} else {
								if (entityiterator instanceof Monster) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:abyssal_damage")))), 99999);
									found_mob = true;
									ExtremeMonstersMod.queueServerWork(2, () -> {
										{
											Entity _ent = entityiterator;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill");
											}
										}
									});
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
										if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							}
						}
					}
					sx = -12;
					for (int index12 = 0; index12 < 28; index12++) {
						sy = -12;
						for (int index13 = 0; index13 < 28; index13++) {
							sz = -12;
							for (int index14 = 0; index14 < 28; index14++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.COBWEB) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									found_mob = true;
									world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.CLOUD, (x + sx + 0.5), (y + sy + 0.5), (z + sz + 0.5), 3, 0.2, 0.2, 0.2, 0.1);
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found_mob) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
							}
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.INFINITE_WATER_AMULET.get()) {
				if (!(entity instanceof Player _plrCldCheck125 && _plrCldCheck125.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
						}
					}
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new WaterPelletEntity(ExtremeMonstersModEntities.WATER_PELLET.get(), level) {
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
							}.getArrow(projectileLevel, 0, 0, (byte) 999);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.SMELTING_STICK.get()) {
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
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
				}
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
					for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
						if (world instanceof Level _level136 && _level136.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(itemstackiterator), _level136).isPresent()) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = (world instanceof Level _lvlSmeltResult
										? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(itemstackiterator), _lvlSmeltResult)
												.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
										: ItemStack.EMPTY).copy();
								_setstack.setCount(itemstackiterator.getCount());
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = itemstackiterator;
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
							}
							success = true;
						}
					}
				}
				if (success == true) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.PLAYERS, (float) 0.1, (float) 1.6);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.PLAYERS, (float) 0.1, (float) 1.6, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLAME, x, y, z, 20, 0.5, 1, 0.5, 0.2);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLASH, x, y, z, 3, 0.5, 1, 0.5, 0.2);
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(500 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof EnderDragon) {
							if ((entityiterator instanceof LivingEntity _livingEntity153 && _livingEntity153.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS)
									? _livingEntity153.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue()
									: 0) == 0) {
								found_mob = true;
								target = entityiterator;
							}
						}
					}
				}
				if (found_mob) {
					if (ExtremeMonstersModVariables.MapVariables.get(world).is_killed_hyper_enderdragon == false) {
						if (world instanceof ServerLevel _origLevel) {
							LevelAccessor _worldorig = world;
							world = _origLevel.getServer().getLevel(Level.END);
							if (world != null) {
								for (Entity entityiterator : new ArrayList<>(world.players())) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A74\"So be it. The end has come.\""), false);
								}
							}
							world = _worldorig;
						}
						ExtremeMonstersModVariables.MapVariables.get(world).is_killed_hyper_enderdragon = true;
						ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.MASTER, 1, (float) 0.8);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.MASTER, 1, (float) 0.8, false);
						}
					}
					if (!(target == null)) {
						if (target instanceof LivingEntity _livingEntity161 && _livingEntity161.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
							_livingEntity161.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
						if (target instanceof LivingEntity _livingEntity162 && _livingEntity162.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
							_livingEntity162.getAttribute(Attributes.MAX_HEALTH).setBaseValue(500);
						if (target instanceof LivingEntity _entity)
							_entity.setHealth(500);
						target.setCustomName(Component.literal("\u00A74Hyper Ender Dragon"));
					}
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
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()).copy();
							_setstack.setCount((int) (item.getCount() - 1));
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.HYPER_GOLD_PICKAXE.get()) {
				if (!(entity instanceof Player _plrCldCheck170 && _plrCldCheck170.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(item.getItem(), 20);
					sx = -10;
					for (int index15 = 0; index15 < 21; index15++) {
						sy = -10;
						for (int index16 = 0; index16 < 21; index16++) {
							sz = -10;
							for (int index17 = 0; index17 < 21; index17++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("c:ores")))) {
									found_mob = true;
									{
										BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
										Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
										world.destroyBlock(_pos, false);
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found_mob) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
							}
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.PERFECT_MATTER_HAMMER.get()) {
				if (!(entity instanceof Player _plrCldCheck178 && _plrCldCheck178.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(item.getItem(), 3);
					sx = -14;
					for (int index18 = 0; index18 < 31; index18++) {
						sy = -14;
						for (int index19 = 0; index19 < 31; index19++) {
							sz = -14;
							for (int index20 = 0; index20 < 31; index20++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("c:ores")))) {
									found_mob = true;
									{
										BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
										Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
										world.destroyBlock(_pos, false);
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found_mob) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
							}
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.INFINITE_LAVA_AMULET.get()) {
				if (!(entity instanceof Player _plrCldCheck186 && _plrCldCheck186.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
						}
					}
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new LavaPelletEntity(ExtremeMonstersModEntities.LAVA_PELLET.get(), level) {
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
							}.getArrow(projectileLevel, 0, 0, (byte) 999);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.WITHERED_DARK_MATTER_LAUNCHER.get()) {
				if (!(entity instanceof Player _plrCldCheck192 && _plrCldCheck192.getCooldowns().isOnCooldown(item.getItem())) && (item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ammo") > 10 || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity))) {
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
						paste_item = item.copy();
						{
							final String _tagName = "ammo";
							final double _tagValue = (paste_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ammo") - 10);
							CustomData.update(DataComponents.CUSTOM_DATA, paste_item, tag -> tag.putDouble(_tagName, _tagValue));
						}
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).applyComponents(paste_item.getComponents());
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(item.getItem(), 100);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
						}
					}
					if (item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Griefing")) {
						for (int index21 = 0; index21 < 15; index21++) {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new GriefingPlayerWitheredDarkMatterMainEntity(ExtremeMonstersModEntities.GRIEFING_PLAYER_WITHERED_DARK_MATTER_MAIN.get(), level) {
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
									}.getArrow(projectileLevel, entity, 30, 2, (byte) 99999);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.1, 999);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						}
					} else {
						for (int index22 = 0; index22 < 15; index22++) {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new PlyerWitheredDarkMatterMainEntity(ExtremeMonstersModEntities.PLYER_WITHERED_DARK_MATTER_MAIN.get(), level) {
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
									}.getArrow(projectileLevel, entity, 30, 2, (byte) 99999);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.1, 999);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						}
					}
				}
			}
			if (item.getItem() == ExtremeMonstersModItems.HYPER_GOLDEN_AXE.get()) {
				if (!(entity instanceof Player _plrCldCheck210 && _plrCldCheck210.getCooldowns().isOnCooldown(item.getItem()))) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(item.getItem(), 20);
					sx = -12;
					for (int index23 = 0; index23 < 25; index23++) {
						sy = -12;
						for (int index24 = 0; index24 < 25; index24++) {
							sz = -12;
							for (int index25 = 0; index25 < 25; index25++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))
										|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("c:logs")))) {
									found_mob = true;
									{
										BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
										Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
										world.destroyBlock(_pos, false);
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found_mob) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.MASTER, (float) 0.1, 1, false);
							}
						}
					}
				}
			}
		}
	}
}
