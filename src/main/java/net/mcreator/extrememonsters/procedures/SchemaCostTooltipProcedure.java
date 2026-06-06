package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class SchemaCostTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_DIAMOND.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("C\u2083\u2082He\u2084"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_IRON.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Fe\u2086"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_AMETHYST.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Si\u2084O\u2088Fe\u2081"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_GOLD.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Au\u2084"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_COPPER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Cu\u2086"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_QUARTZ.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Si\u2084O\u2088"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_TUNGSTEN.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("W\u2084Cu\u2082"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_REDSTONE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Fe\u2082Si\u2084O\u2081\u2082He\u2084"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_NETHERITE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Fe\u2088W\u2084C\u2081\u2082Au\u2083\u2082Cu\u2084"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_STONE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Si\u2084O\u2082"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_COAL.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("C\u2088H\u2084O\u2082"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SCHEMA_NETHER_STAR.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("C\u2089\u2086Au\u2086\u2084W\u2086\u2084Si\u2081\u2082\u2088O\u2082\u2085\u2086"));
			} else {
				tooltip.add(1, Component.literal("Press Shift to view required elements for output"));
			}
		}
	}
}
