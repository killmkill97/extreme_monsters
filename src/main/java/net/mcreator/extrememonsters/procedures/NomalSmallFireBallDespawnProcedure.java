package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;

public class NomalSmallFireBallDespawnProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
