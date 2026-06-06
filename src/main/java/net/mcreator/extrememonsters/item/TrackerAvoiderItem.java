
package net.mcreator.extrememonsters.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.procedures.TrackerAvoiderEffectProcedure;

public class TrackerAvoiderItem extends Item {
	public TrackerAvoiderItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		TrackerAvoiderEffectProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
