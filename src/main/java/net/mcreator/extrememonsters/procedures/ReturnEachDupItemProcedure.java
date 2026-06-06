package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

public class ReturnEachDupItemProcedure {
	public static ItemStack execute(ItemStack Item) {
		if (Item.getItem() == ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_BLACK_HOLE_MATTER.get());
		}
		if (Item.getItem() == Items.IRON_INGOT) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_IRON_INGOT.get());
		}
		if (Item.getItem() == Items.GOLD_INGOT) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_GOLD_INGOT.get());
		}
		if (Item.getItem() == Items.DIAMOND) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_DIAMOND.get());
		}
		if (Item.getItem() == ExtremeMonstersModItems.DARK_MATTER_FELLET.get()) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_DARK_MATTER_PELLET.get());
		}
		if (Item.getItem() == ExtremeMonstersModItems.MATTER_CATALYST_SHARD.get()) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_MATTER_CATALYST_SHARD.get());
		}
		if (Item.getItem() == ExtremeMonstersModItems.INFERNO_MATTER.get()) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_INFERNO_MATTER.get());
		}
		if (Item.getItem() == Blocks.DRAGON_EGG.asItem()) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_DRAGON_EGG_CHUNK.get());
		}
		if (Item.getItem() == ExtremeMonstersModItems.STARS_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_SOUL.get());
		}
		if (Item.getItem() == Items.NETHER_STAR) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_NETHER_STAR.get());
		}
		if (Item.getItem() == Items.LEATHER) {
			return new ItemStack(ExtremeMonstersModItems.DUPLICATED_LEATHER.get());
		}
		return new ItemStack(Blocks.AIR);
	}
}
