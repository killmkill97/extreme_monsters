package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

import com.mojang.datafixers.schemas.Schema;

public class GetSchemaItemProcedure {
	public static ItemStack execute(ItemStack Schema) {
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_DIAMOND.get()) {
			return new ItemStack(Items.DIAMOND);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_IRON.get()) {
			return new ItemStack(Items.IRON_INGOT);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_AMETHYST.get()) {
			return new ItemStack(Items.AMETHYST_SHARD);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_GOLD.get()) {
			return new ItemStack(Items.GOLD_INGOT);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_COPPER.get()) {
			return new ItemStack(Items.COPPER_INGOT);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_QUARTZ.get()) {
			return new ItemStack(Items.QUARTZ);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_TUNGSTEN.get()) {
			return new ItemStack(ExtremeMonstersModItems.TUNGSTEN_INGOT.get());
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_REDSTONE.get()) {
			return new ItemStack(Items.REDSTONE);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_NETHERITE.get()) {
			return new ItemStack(Items.NETHERITE_INGOT);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_STONE.get()) {
			return new ItemStack(Blocks.COBBLESTONE);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_COAL.get()) {
			return new ItemStack(Items.COAL);
		}
		if (Schema.getItem() == ExtremeMonstersModItems.SCHEMA_NETHER_STAR.get()) {
			return new ItemStack(Items.NETHER_STAR);
		}
		return new ItemStack(Blocks.AIR);
	}
}
