package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class AssemblerWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				if (level instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
					if (_entityStorage != null)
						return _entityStorage.getEnergyStored();
				}
				return 0;
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 150) {
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get()), new ItemStack(Items.NETHERITE_INGOT), new ItemStack(Items.QUARTZ), new ItemStack(Blocks.REDSTONE_BLOCK),
					new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR), new ItemStack(ExtremeMonstersModItems.SPEED_UPGRADE_1.get()), 150);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.BASIC_MACHINE_FRAME.get()), new ItemStack(ExtremeMonstersModItems.DARK_MATTER.get()), new ItemStack(Blocks.DIAMOND_BLOCK),
					new ItemStack(ExtremeMonstersModItems.HYPER_GUNPOWDER.get()), new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR), new ItemStack(ExtremeMonstersModBlocks.ADVANCED_MACHINE_FRAME.get()), 150);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.AWKWARD_MACHINE_FRAME.get()), new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Items.DIAMOND), new ItemStack(Blocks.COPPER_BLOCK),
					new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR), new ItemStack(ExtremeMonstersModBlocks.BASIC_MACHINE_FRAME.get()), 150);
		}
	}
}
