
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HyperStaffItem extends Item {
	public HyperStaffItem() {
		super(new Item.Properties().durability(100).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
