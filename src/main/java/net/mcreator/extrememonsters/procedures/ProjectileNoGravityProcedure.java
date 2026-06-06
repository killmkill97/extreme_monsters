package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

public class ProjectileNoGravityProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
	}
}
