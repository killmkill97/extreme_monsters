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
public class ExtraFunctionSowrdsDamageProcedure {
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
		if (itemstack.getItem() == ExtremeMonstersModItems.DARK_MATTER_SWORD.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("9 damage to around mobs."));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.INFERNO_MATTER_SWORD.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("13 damage to around mobs."));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.DRAGON_MATTER_SWORD.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("18 damage to around mobs and " + "granting Weakness and Slowness.")));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.WITHER_MATTER_SWORD.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("24 damage to around mobs and " + "granting Wither and Weakness and Slowness.")));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Making Ender dragon to Hyper Ender Dragon."));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.HYPER_GOLD_PICKAXE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Mining all ores in 13\u00D713\u00D713."));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.INFINITE_LAVA_AMULET.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Shot Lava Pellet."));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.INFINITE_WATER_AMULET.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Shot Water Pellet."));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SMELTING_STICK.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Smelts all smeltable items in your inventory."));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.HYPER_GOLDEN_AXE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Cut down all wood(log) in 13\u00D713\u00D713."));
			} else {
				tooltip.add(Component.literal("Press shift show Extra Functions."));
			}
		}
	}
}
