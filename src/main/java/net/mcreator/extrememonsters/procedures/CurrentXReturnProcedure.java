package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

public class CurrentXReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "X: " + new java.text.DecimalFormat("##").format(entity.getX());
	}
}
