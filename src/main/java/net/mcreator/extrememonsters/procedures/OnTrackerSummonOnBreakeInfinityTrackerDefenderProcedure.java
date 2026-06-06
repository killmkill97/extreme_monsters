package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OnTrackerSummonOnBreakeInfinityTrackerDefenderProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getState());
	}

	public static void execute(LevelAccessor world, BlockState blockstate) {
		execute(null, world, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, BlockState blockstate) {
		if (blockstate.getBlock() == ExtremeMonstersModBlocks.INFINITY_TRACKER_DEFENDER.get()) {
			ExtremeMonstersModVariables.MapVariables.get(world).infinity_tracker_defender_working = false;
			ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
