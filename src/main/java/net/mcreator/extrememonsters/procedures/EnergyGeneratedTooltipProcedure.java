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

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class EnergyGeneratedTooltipProcedure {
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
		//solar panel
		if (itemstack.getItem() == ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_SOLAR_PLANEL.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("100 FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.DARK_MATTER_SOLAR_PANEL.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("1200 FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.INFERNO_MATTER_SOLAR_PANEL.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("15k FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.DRAGON_MATTER_SOLAR_PANEL.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("120k FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.WITHER_MATTER_SOLAR_PANEL.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("15 HFE/t (1.5M FE/t)"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		} //combustion generator
		if (itemstack.getItem() == ExtremeMonstersModBlocks.COMBUSTION_GENERATOR.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("500 FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.COMBUSTION_GENERATOR_MK_2.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("60000 FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.COMBUSTION_GENERATOR_MK_3.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("75k FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.COMBUSTION_GENERATOR_MK_4.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("600k FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.COMBUSTION_GENERATOR_MK_5.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("75 HFE/t (7.5M FE/t)"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		} //matter fusion reactor
		if (itemstack.getItem() == ExtremeMonstersModBlocks.MATTER_FUSION_REACTOR_1.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("1000 FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.MATTER_FUSION_REACTOR_2.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("12000 FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.MATTER_FUSION_REACTOR_3.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("100k FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.MATTER_FUSION_REACTOR_4.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("1.2M FE/t"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.MATTER_FUSION_REACTOR_5.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("150 HFE/t (15M FE/t)"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		} //misc
		if (itemstack.getItem() == ExtremeMonstersModBlocks.OMEGA_D_CORE.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("2400 HFE/t (240M FE/t)"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.DYSON_RING_CONTROLLER.get().asItem()) {
			if (Screen.hasControlDown()) {
				tooltip.add(1, Component.literal("Maximum output 40000 HFE/t (4B FE/t)"));
			} else {
				tooltip.add(1, Component.literal("Press Ctrl to show energy output per tick"));
			}
		}
	}
}
