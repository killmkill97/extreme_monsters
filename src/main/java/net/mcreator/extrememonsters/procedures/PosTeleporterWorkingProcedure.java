package net.mcreator.extrememonsters.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class PosTeleporterWorkingProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (CanStringConvertNumberProcedure.execute(guistate.containsKey("text:tx") ? ((EditBox) guistate.get("text:tx")).getValue() : "")
				&& CanStringConvertNumberProcedure.execute(guistate.containsKey("text:ty") ? ((EditBox) guistate.get("text:ty")).getValue() : "")
				&& CanStringConvertNumberProcedure.execute(guistate.containsKey("text:tz") ? ((EditBox) guistate.get("text:tz")).getValue() : "")) {
			{
				Entity _ent = entity;
				_ent.teleportTo((new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:tx") ? ((EditBox) guistate.get("text:tx")).getValue() : "") + 0.5), (new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:ty") ? ((EditBox) guistate.get("text:ty")).getValue() : "") + 0.5), (new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:tz") ? ((EditBox) guistate.get("text:tz")).getValue() : "") + 0.5));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:tx") ? ((EditBox) guistate.get("text:tx")).getValue() : "") + 0.5), (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:ty") ? ((EditBox) guistate.get("text:ty")).getValue() : "") + 0.5), (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:tz") ? ((EditBox) guistate.get("text:tz")).getValue() : "") + 0.5), _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:tx") ? ((EditBox) guistate.get("text:tx")).getValue() : "") + 0.5), (new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:ty") ? ((EditBox) guistate.get("text:ty")).getValue() : "") + 0.5), (new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:tz") ? ((EditBox) guistate.get("text:tz")).getValue() : "") + 0.5), 300, 0.5, 1, 0.5, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:tx") ? ((EditBox) guistate.get("text:tx")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:ty") ? ((EditBox) guistate.get("text:ty")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:tz") ? ((EditBox) guistate.get("text:tz")).getValue() : "")), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.travel")), SoundSource.PLAYERS, (float) 0.1, 1);
				} else {
					_level.playLocalSound(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:tx") ? ((EditBox) guistate.get("text:tx")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:ty") ? ((EditBox) guistate.get("text:ty")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:tz") ? ((EditBox) guistate.get("text:tz")).getValue() : ""), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.travel")), SoundSource.PLAYERS, (float) 0.1, 1, false);
				}
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cInvalid character"), true);
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
