package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class ShowLoadedAmmoInTootipProcedure {
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
		if (itemstack.getItem() == ExtremeMonstersModItems.BLACK_HOLE_MATTER_LASER_EMITTER.get() || itemstack.getItem() == ExtremeMonstersModItems.STASIS_LASER_EMITTER.get() || itemstack.getItem() == ExtremeMonstersModItems.INFERNO_RAIL_GUN.get()
				|| itemstack.getItem() == ExtremeMonstersModItems.STASIS_RAIL_GUN.get() || itemstack.getItem() == ExtremeMonstersModItems.NOMAL_ARROW_BARRAGER.get()
				|| itemstack.getItem() == ExtremeMonstersModItems.WITHERED_DARK_MATTER_LAUNCHER.get()) {
			if (Screen.hasAltDown()) {
				tooltip.add(1, Component.literal(("loaded ammo: " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ammo")))));
			} else {
				tooltip.add(1, Component.literal("Press alt show loaded ammo"));
			}
		}
	}
}
