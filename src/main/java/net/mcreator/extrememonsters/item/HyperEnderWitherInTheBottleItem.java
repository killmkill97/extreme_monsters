
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HyperEnderWitherInTheBottleItem extends Item {
	public HyperEnderWitherInTheBottleItem() {
		super(new Item.Properties().stacksTo(16).fireResistant().rarity(Rarity.EPIC));
	}
}
