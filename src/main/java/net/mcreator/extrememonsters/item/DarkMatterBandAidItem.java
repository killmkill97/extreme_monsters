
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DarkMatterBandAidItem extends Item {
	public DarkMatterBandAidItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
