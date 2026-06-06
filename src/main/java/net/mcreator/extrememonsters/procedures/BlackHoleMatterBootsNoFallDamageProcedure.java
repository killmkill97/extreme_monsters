package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

public class BlackHoleMatterBootsNoFallDamageProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
	}
}
