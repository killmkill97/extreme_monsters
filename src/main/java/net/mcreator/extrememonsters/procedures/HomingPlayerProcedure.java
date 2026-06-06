package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.entity.NomalArrowEntity;
import net.mcreator.extrememonsters.entity.HomingArrowPlayerEntity;
import net.mcreator.extrememonsters.entity.HomingArrowEntity;
import net.mcreator.extrememonsters.entity.CreeperEggEntity;

import java.util.List;
import java.util.Comparator;

public class HomingPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof ItemEntity)) {
					if (!(entityiterator instanceof ExperienceOrb)) {
						if (!(new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
								}
								return false;
							}
						}.checkGamemode(entityiterator))) {
							if (!(new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
									} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
									}
									return false;
								}
							}.checkGamemode(entityiterator))) {
								if (!(entityiterator instanceof Arrow)) {
									if (!(entityiterator instanceof SpectralArrow)) {
										if (!(entityiterator instanceof WitherSkull)) {
											if (!(entityiterator instanceof LargeFireball)) {
												if (!(entityiterator instanceof DragonFireball)) {
													if (!(entityiterator instanceof FireworkRocketEntity)) {
														if (!(entityiterator instanceof SmallFireball)) {
															if (!(entityiterator instanceof Snowball)) {
																if (!(entityiterator instanceof Player)) {
																	if (!(entityiterator instanceof HomingArrowEntity)) {
																		if (!(entityiterator instanceof NomalArrowEntity)) {
																			if (!(entityiterator instanceof HomingArrowPlayerEntity)) {
																				if (!(entityiterator instanceof CreeperEggEntity)) {
																					immediatesourceentity.push((entityiterator.getX() * 0.1 - immediatesourceentity.getX() * 0.1), (entityiterator.getY() * 0.1 - immediatesourceentity.getY() * 0.1),
																							(entityiterator.getZ() * 0.1 - immediatesourceentity.getZ() * 0.1));
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
