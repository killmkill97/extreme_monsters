package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MirrorOfDespairDamageSaveProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).mirror_of_despair_work) {
			if (sourceentity == null) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, 1, 2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, 1, 2, false);
					}
				}
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				{
					ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
					_vars.mirror_of_despair_damage_saved = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).mirror_of_despair_damage_saved + amount;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, 1, 2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.land")), SoundSource.PLAYERS, 1, 2, false);
					}
				}
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if (!(sourceentity instanceof MagmaCube)) {
					if (!(sourceentity instanceof Slime)) {
						{
							ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
							_vars.mirror_of_despair_damage_saved = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).mirror_of_despair_damage_saved + amount;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
		}
	}
}
