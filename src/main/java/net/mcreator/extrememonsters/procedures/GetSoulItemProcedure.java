package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

public class GetSoulItemProcedure {
	public static ItemStack execute(ItemStack soul) {
		if (soul.getItem() == ExtremeMonstersModItems.TRACKERS_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_ZOMBIES_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_ROTTEN_FLESH.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_SKELETONS_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_BONE.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_CREEPERS_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_GUNPOWDER.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_SPIDERS_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_SPIDER_EYE.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_ZOMBIFIED_PIGLINS_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_GOLD_NUGGET.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_MAGMA_CUBES_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_MAGMA_CREAM.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_WITHER_SKELETONS_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_WITHERED_BONE.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_BLAZES_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_BLAZE_ROD.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.HYPER_ENDERMANS_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_ENDER_PEARL.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.ULTIMATE_SOUL.get()) {
			return new ItemStack(ExtremeMonstersModItems.HYPER_ESSENCE_3.get());
		}
		if (soul.getItem() == ExtremeMonstersModItems.USABLE_STARS_SOUL.get()) {
			return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("extreme_monsters:qss_stars_soul_output"))).getRandomElement(RandomSource.create())
					.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
		}
		return new ItemStack(Blocks.AIR);
	}
}
