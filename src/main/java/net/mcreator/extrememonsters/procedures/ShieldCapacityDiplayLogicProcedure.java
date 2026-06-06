package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

public class ShieldCapacityDiplayLogicProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ExtremeMonstersModItems.SUPER_DAMAGE_PROTECTOR.get())) : false) {
			return true;
		}
		return false;
	}
}
