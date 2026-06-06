package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

public class CurrentZReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Z: " + new java.text.DecimalFormat("##").format(entity.getZ());
	}
}
