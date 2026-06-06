package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class WitheredDarkMatterLunacherGriefingModeGlowingProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Griefing")) {
			return true;
		}
		return false;
	}
}
