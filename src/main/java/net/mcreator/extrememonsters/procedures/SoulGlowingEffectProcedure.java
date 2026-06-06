package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.item.ItemStack;

public class SoulGlowingEffectProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.isDamaged()) {
			return false;
		}
		return true;
	}
}
