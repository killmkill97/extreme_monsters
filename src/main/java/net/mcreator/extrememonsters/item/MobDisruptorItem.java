
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MobDisruptorItem extends Item {
	public MobDisruptorItem() {
		super(new Item.Properties().durability(64).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
