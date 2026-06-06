package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NoEndProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getDimension(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, ResourceKey<Level> dimension, Entity entity) {
		execute(null, world, x, y, z, dimension, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, ResourceKey<Level> dimension, Entity entity) {
		if (dimension == null || entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (ExtremeMonstersConfigurationConfiguration.ALWAYS_ALLOW_END.get() == false) {
			if (entity instanceof Player) {
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
					if (dimension == Level.END) {
						if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ExtremeMonstersModItems.END_PASS.get())) : false)
								&& !(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ExtremeMonstersModItems.COMBINED_PASS.get())) : false)) {
							if (event instanceof ICancellableEvent _cancellable) {
								_cancellable.setCanceled(true);
							}
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, y, z, 8, Level.ExplosionInteraction.BLOCK);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You are not worthy to explore The End"), true);
							sx = -4;
							for (int index0 = 0; index0 < 9; index0++) {
								sy = -4;
								for (int index1 = 0; index1 < 9; index1++) {
									sz = -4;
									for (int index2 = 0; index2 < 9; index2++) {
										if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.END_PORTAL_FRAME) {
											world.destroyBlock(BlockPos.containing(x + sx, y + sy, z + sz), false);
											if (world instanceof ServerLevel _level)
												FallingBlockEntity.fall(_level, BlockPos.containing(x + sx, y + sy, z + sz), Blocks.CRYING_OBSIDIAN.defaultBlockState());
										}
										if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.END_PORTAL) {
											world.destroyBlock(BlockPos.containing(x + sx, y + sy, z + sz), false);
										}
										sz = sz + 1;
									}
									sy = sy + 1;
								}
								sx = sx + 1;
							}
						} else {
							{
								ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
								_vars.can_elytra_fly = true;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
				}
			}
		}
	}
}
