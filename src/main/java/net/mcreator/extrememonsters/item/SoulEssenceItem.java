
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SoulEssenceItem extends Item {
	public SoulEssenceItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE));
	}
}
