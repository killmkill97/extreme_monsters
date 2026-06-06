package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ComputeAfterExtremeModeStartProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (ExtremeMonstersModVariables.MapVariables.get(world).Extreme && !ExtremeMonstersModVariables.MapVariables.get(world).spawn_basic_tracker) {
			ExtremeMonstersModVariables.MapVariables.get(world).after_extreme_mode_start = ExtremeMonstersModVariables.MapVariables.get(world).after_extreme_mode_start + 1;
			ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
			if (ExtremeMonstersModVariables.MapVariables.get(world).after_extreme_mode_start >= 24000) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cNow stronger Trackers are spawning! Be careful!"), false);
				ExtremeMonstersModVariables.MapVariables.get(world).spawn_basic_tracker = true;
				ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
