package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TrackerSpawnProcedure {
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
		double rx = 0;
		double rz = 0;
		if (ExtremeMonstersModVariables.MapVariables.get(world).Extreme) {
			if (ExtremeMonstersConfigurationConfiguration.TRACKER_SPAWN.get()) {
				if (!ExtremeMonstersModVariables.MapVariables.get(world).infinity_tracker_defender_working) {
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
						if (Mth.nextInt(RandomSource.create(), 1, 400) == 1) {
							rx = x + Mth.nextInt(RandomSource.create(), 25, 50);
							if (Math.random() >= 0.5) {
								rx = rx * (-1);
							}
							rz = z + Mth.nextInt(RandomSource.create(), 25, 50);
							if (Math.random() >= 0.5) {
								rz = rz * (-1);
							}
							if ((world.getBlockState(BlockPos.containing(rx, y, rz))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(rx, y + 1, rz))).getBlock() == Blocks.AIR) {
								if (ExtremeMonstersModVariables.MapVariables.get(world).spawn_basic_tracker) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon extreme_monsters:tracker " + (rx + " ") + (y + " ") + (rz + " ") + "{NeoForgeData:{target:\"" + entity.getStringUUID() + "\"}}"));
								} else {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon extreme_monsters:weak_tracker " + (rx + " ") + (y + " ") + (rz + " ") + "{NeoForgeData:{target:\"" + entity.getStringUUID() + "\"}}"));
								}
								if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ExtremeMonstersModItems.TRACKER_SPAWN_DETECTOR.get())) : false) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Tracker has been spawned. get careful!"), false);
								}
							}
						}
						if (ExtremeMonstersConfigurationConfiguration.FLYING_TRACKER_SPAWN.get()) {
							if (Mth.nextInt(RandomSource.create(), 1, 750) == 1) {
								rx = x + Mth.nextInt(RandomSource.create(), -50, 50);
								rz = z + Mth.nextInt(RandomSource.create(), -50, 50);
								if (ExtremeMonstersModVariables.MapVariables.get(world).spawn_basic_tracker) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon extreme_monsters:flying_tracker " + (rx + " ") + (y + " ") + (rz + " ") + "{NeoForgeData:{target:\"" + entity.getStringUUID() + "\"}}"));
								} else {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon extreme_monsters:weak_flying_tracker " + (rx + " ") + (y + " ") + (rz + " ") + "{NeoForgeData:{target:\"" + entity.getStringUUID() + "\"}}"));
								}
								if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ExtremeMonstersModItems.TRACKER_SPAWN_DETECTOR.get())) : false) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Flying Tracker has been spawned. get careful!"), false);
								}
							}
						}
					}
				}
			}
		}
	}
}
