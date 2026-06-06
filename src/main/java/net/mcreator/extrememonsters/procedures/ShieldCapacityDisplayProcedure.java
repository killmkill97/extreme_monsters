package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;

public class ShieldCapacityDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity >= 300) {
			return "300 / 300";
		} else if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity <= 0) {
			return "0 / 300";
		}
		return new java.text.DecimalFormat("##").format(entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity) + " / 300";
	}
}
