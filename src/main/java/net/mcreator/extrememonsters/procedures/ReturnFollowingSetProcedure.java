package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnFollowingSetProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("follow_owner")) {
			return true;
		}
		return false;
	}
}
