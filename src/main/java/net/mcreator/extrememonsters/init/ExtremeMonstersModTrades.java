
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class ExtremeMonstersModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == ExtremeMonstersModVillagerProfessions.SURVIVALISTS.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get(), 15), new ItemStack(Items.EMERALD), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_APPLE.get()), 3, 5, 0.05f));
		}
		if (event.getType() == ExtremeMonstersModVillagerProfessions.SURVIVALISTS.get()) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Blocks.TNT), new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_BOMB.get()), 5, 10, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_FUEL.get(), 8), new ItemStack(Items.EMERALD), 10, 10, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_SHARD.get()), 5, 10, 0.05f));
		}
		if (event.getType() == ExtremeMonstersModVillagerProfessions.SURVIVALISTS.get()) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ExtremeMonstersModItems.DARK_MATTER.get()), new ItemStack(Items.EMERALD, 3), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(ExtremeMonstersModItems.DAGGER_FOR_TRACKER.get()), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_DAGGER.get()), 10, 40, 0.05f));
		}
		if (event.getType() == ExtremeMonstersModVillagerProfessions.SURVIVALISTS.get()) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 15), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_APPLE.get()), 2, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 40), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_BOMB.get()), 3, 20, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ExtremeMonstersModItems.HYPER_DRAGON_SKIN.get()), new ItemStack(Blocks.EMERALD_BLOCK, 10), 1, 30, 0.05f));
		}
		if (event.getType() == ExtremeMonstersModVillagerProfessions.SURVIVALISTS.get()) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ExtremeMonstersModItems.SINGULARITY.get()), new ItemStack(Items.EMERALD, 64), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(ExtremeMonstersModBlocks.ADVANCED_MACHINE_FRAME.get()), new ItemStack(ExtremeMonstersModBlocks.PROJECTILE_REMOVER.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 15), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_EXP_BOTTLE.get()), 1, 5, 0.05f));
		}
	}
}
