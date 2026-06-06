
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DuplicatedGoldIngotItem extends Item {
	public DuplicatedGoldIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
