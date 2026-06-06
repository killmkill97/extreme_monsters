package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;

public class TtteeessstttProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Progress_bar_display = 0;
		double local_progress_bar = 0;
		local_progress_bar = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity / 2.34375;
	}
}
