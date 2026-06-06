
package net.mcreator.extrememonsters.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.procedures.UpgradedArrowRemoverDamageProcedure;

public class UpgradedArrowRemoverItem extends Item {
	public UpgradedArrowRemoverItem() {
		super(new Item.Properties().durability(128000).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		UpgradedArrowRemoverDamageProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
