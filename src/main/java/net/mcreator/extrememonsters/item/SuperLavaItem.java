
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.extrememonsters.init.ExtremeMonstersModFluids;

public class SuperLavaItem extends BucketItem {
	public SuperLavaItem() {
		super(ExtremeMonstersModFluids.SUPER_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
