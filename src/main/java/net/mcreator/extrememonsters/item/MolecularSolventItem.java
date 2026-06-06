
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.extrememonsters.init.ExtremeMonstersModFluids;

public class MolecularSolventItem extends BucketItem {
	public MolecularSolventItem() {
		super(ExtremeMonstersModFluids.MOLECULAR_SOLVENT.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.RARE));
	}
}
