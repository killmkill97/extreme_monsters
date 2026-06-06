
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HyperBoneItem extends Item {
	public HyperBoneItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
