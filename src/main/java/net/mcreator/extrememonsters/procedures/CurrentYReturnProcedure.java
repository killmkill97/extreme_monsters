package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

public class CurrentYReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Y: " + new java.text.DecimalFormat("##").format(entity.getY());
	}
}
