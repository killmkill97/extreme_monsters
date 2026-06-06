package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class CheckCanUseAbilityItemsProcedure {
	public static boolean execute(Entity entity, ItemStack TargetItem) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TargetItem.getItem() && !(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(TargetItem.getItem()))) {
			return true;
		}
		return false;
	}
}
