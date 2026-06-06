
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class ExtremeMonstersModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == ExtremeMonstersModItems.DARK_MATTER_FUEL.get())
			event.setBurnTime(51200);
		else if (itemstack.getItem() == ExtremeMonstersModItems.BLACK_HOLE_MATTER_FUEL.get())
			event.setBurnTime(6400);
		else if (itemstack.getItem() == ExtremeMonstersModItems.INFERNO_MATTER_FUEL.get())
			event.setBurnTime(204800);
		else if (itemstack.getItem() == ExtremeMonstersModItems.DRAGON_MATTER_FUEL.get())
			event.setBurnTime(409600);
		else if (itemstack.getItem() == ExtremeMonstersModItems.WITHER_MATTER_FUEL.get())
			event.setBurnTime(819200);
	}
}
