package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class MoreInfoTooltipsProcedure {
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
		if (itemstack.getItem() == ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Can use Matter Fusion Reactor fuels."));
				tooltip.add(2, Component.literal("Breaks each matter blocks easily."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations"));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.DARK_MATTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Can use Matter Fusion Reactor fuels."));
				tooltip.add(2, Component.literal("Breaks each matter blocks easily."));
				tooltip.add(3, Component.literal("Can makes Hyper Magma Cube. "));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.INFERNO_MATTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Breaks each matter blocks easily."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.DRAGON_MATTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Breaks each matter blocks easily."));
				tooltip.add(2, Component.literal("Can makes Hyper Wither "));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.WITHER_MATTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Breaks each matter blocks easily."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SINGULARITY.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Remove all Minecraft harmful effect on in inventory."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.TRACKER_AVOIDER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Grants a beneficial effect when a Tracker is nearby."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.SUPER_MAGMA.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Stronger magma block"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.OMEGA_WRENCH.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Breaks matter blocks and machines(\u03A9-D core and \u03A9-D core stabilizer) easily."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.DUPLICATED_BLACK_HOLE_MATTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Can make Duplicated Bedrock"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.MOB_IMMOBILIZER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Prevents mob movement"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.EXPLOSIVE_EMITTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("25 Damage to around mob and grating effect \"Explosive\""));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.ABYSSAL_COUNT_DOWN.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Holding this item for 16 seconds summons abyssal power."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("extreme_monsters:matter_hammers")))) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Hammer is Multi-tool(Pickaxe, Axe, Shovel, Hoe, etc)"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.HYPER_MOB_DESIGNATOR.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Can be transformed into a Hyper Mob when hyperification is possible"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.DARK_MATTER_RELAY.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.INFERNO_MATTER_RELAY.get().asItem()
				|| itemstack.getItem() == ExtremeMonstersModBlocks.DRAGON_MATTER_RELAY.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.WITHER_MATTER_RELAY.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Distributes FE (RF) to nearby blocks."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_RELAY.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Transfers FE (RF) to adjacent blocks."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.WIRELESS_AUTO_MENDER.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Repairs all items in your inventory."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.TRACKERS_ABYSS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Eliminates any Trackers within range."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.TRACKERS_VOID.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Eliminates any Trackers within more range."));
				tooltip.add(2, Component.literal("and collect Black Hole Matter"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.HYPER_STAFF.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Knocks back all nearby mobs and deals damage."));
				tooltip.add(1, Component.literal("and collect Black Hole Matter"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.TRACKER_DEFENDER.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.TRACKER_DEFENDER_MK_2.get().asItem()
				|| itemstack.getItem() == ExtremeMonstersModBlocks.TRACKER_DEFENDER_MK_3.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.TRACKER_DEFENDER_MK_4.get().asItem()
				|| itemstack.getItem() == ExtremeMonstersModBlocks.TRACKER_DEFENDER_MK_5.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Passively removes all trackers in range."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.MOB_DISRUPTOR.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Causes nearby mobs to fight each other."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.DUPLICATOR.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Allows you to duplicate a specific item."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.BLACK_HOLE_MATTER_EXP_BOTTLE.get() || itemstack.getItem() == ExtremeMonstersModItems.DARK_MATTER_EXP_BOTTLE.get()
				|| itemstack.getItem() == ExtremeMonstersModItems.INFERNO_MATTER_EXP_BOTTLE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Give Xp"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.NOMAL_ARROW_BARRAGER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Barrge Normal Arrows"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.SUPER_DAMAGE_PROTECTOR.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Activates a protective shield."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.NETHER_PASS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Allows access to Nether."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.END_PASS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Allows access to The End."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.FIERY_SOUL_COLLECTOR.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Can collect hyper Magma Cube's soul."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.HYPER_ESSENCE_3.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Can insert the Ultimate Soul."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.INFINITY_SIMULATION_CHAMBER.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Can craft Hyper Items using the Ultimate Soul."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.INFINITY_MATRIX.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Can craft Matter using the Matter Catalyst."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.INFINITY_TRACKER_DEFENDER.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("This prevents the spawning of the tracker itself."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.ARTIFICIAL_SUN.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Provides a source of power to machines that require solar energy (e.g., solar panels, matter catalyst makers)"));
				tooltip.add(2, Component.literal("and deals damage to undead mobs."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.PLANETARY_REGULATOR.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("You can clear the weather, or fix the day and night cycle."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.QUANTUM_ANCHOR.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("You can teleport to an anchor using a quantum entangler."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.INFERNO_MINING_CONTROLLER.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.INFERNO_MINING_CASING.get().asItem()
				|| itemstack.getItem() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.DRAGON_MINING_CONTROLLER.get().asItem()
				|| itemstack.getItem() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.DRAGON_QUANTUM_DRILL.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("You can use the Fictional Planet Model to obtain various minerals and \"Tungsten\"."));
				tooltip.add(2, Component.literal(" For more details, please refer to the description on CurseForge."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.DRAGON_ITEM_OUTPUT_BLOCK.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.INFERNO_ITEM_OUTPUT_BLOCK.get().asItem()
				|| itemstack.getItem() == ExtremeMonstersModBlocks.DARK_ITEM_OUTPUT_BLOCK.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("This is the block that produces the result of a multi-block structure."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.INFERNO_ENERGY_ACCEPTOR.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.DRAGON_ENERGY_ACCEPTOR.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("This is the power source for the multi-block structure."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.MATTER_CATALYST_BOILER_CONTROLLER.get().asItem() || itemstack.getItem() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get().asItem()
				|| itemstack.getItem() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("This is a multi-block structure that can create the Matter Catalyst Foundation more quickly."));
				tooltip.add(2, Component.literal("For more details, please refer to the description on CurseForge."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModBlocks.DARK_MATTER_GROWTH_ACCELERATOR.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Greatly accelerates the growth of nearby crops."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.PERFECT_ABYSS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Depending on the mode, it can either push or eliminate entities."));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.VAPOR_EMITTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Deals damage to around enemies. (Like Hyper Magma Cube)"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
		if (itemstack.getItem() == ExtremeMonstersModItems.HYPER_ITEM_MAGNET.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(1, Component.literal("Pull items (Hyper Items only)"));
			} else {
				tooltip.add(1, Component.literal("Press shift show more informations."));
			}
		}
	}
}
