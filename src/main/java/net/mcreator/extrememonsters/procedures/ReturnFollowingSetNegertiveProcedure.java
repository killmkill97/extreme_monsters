package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnFollowingSetNegertiveProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("follow_owner")) {
			return false;
		}
		return true;
	}
}
