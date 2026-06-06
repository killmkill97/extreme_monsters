
package net.mcreator.extrememonsters.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.procedures.InfiniteWaterAmuletImmunityFireProcedure;

public class InfiniteWaterAmuletItem extends Item {
	public InfiniteWaterAmuletItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		InfiniteWaterAmuletImmunityFireProcedure.execute(entity);
	}
}
