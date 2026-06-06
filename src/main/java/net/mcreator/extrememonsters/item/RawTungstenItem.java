
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RawTungstenItem extends Item {
	public RawTungstenItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE));
	}
}
