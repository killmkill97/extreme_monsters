package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class InfernoMatterAssemblerWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < 2; index0++) {
			DarkMatterAssemblerWorkProcedure.execute(world, x, y, z);
		}
		if (new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				if (level instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
					if (_entityStorage != null)
						return _entityStorage.getEnergyStored();
				}
				return 0;
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 22500) {
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.DRAGON_MACHINE_FRAME.get()), new ItemStack(ExtremeMonstersModItems.TRACKER_CORE.get()),
					new ItemStack(ExtremeMonstersModItems.WITHER_MATTER.get()), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_CRYSTAL_MATRIX_INGOT.get()), new ItemStack(ExtremeMonstersModItems.SINGULARITY.get()),
					new ItemStack(ExtremeMonstersModItems.MIXED_HYPER_ESSENCE.get()), new ItemStack(ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()), 22500);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.INFERNO_MATTER.get()), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST.get()), new ItemStack(Blocks.DIAMOND_BLOCK),
					new ItemStack(ExtremeMonstersModItems.BLACK_MATTER_INGOT.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()), new ItemStack(ExtremeMonstersModItems.HYPER_GOLD_INGOT.get()),
					new ItemStack(ExtremeMonstersModItems.SINGULARITY.get()), 22500);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.ENDER_DRAGON_IN_THE_BOTTLE.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()),
					new ItemStack(ExtremeMonstersModItems.INFERNO_MATTER.get()), new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_APPLE.get()), new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR),
					new ItemStack(ExtremeMonstersModItems.HYPER_ENDER_DRAGON_IN_THE_BOTTLE.get()), 22500);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.WITHER_IN_THE_BOTTLE.get()), new ItemStack(ExtremeMonstersModItems.DRAGON_MATTER.get()),
					new ItemStack(ExtremeMonstersModBlocks.HYPER_GOLD_INGOT_BLOCK.get()), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_APPLE.get()), new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR),
					new ItemStack(ExtremeMonstersModItems.HYPER_WITHER_IN_THE_BOTTLE.get()), 22500);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK_3X.get()), new ItemStack(ExtremeMonstersModItems.RING_OF_FLIGHT.get()),
					new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_GENERATOR_MK_3.get()), new ItemStack(ExtremeMonstersModItems.DISPOSABLE_HYPER_MOB_DESIGNATOR.get()), new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR),
					new ItemStack(ExtremeMonstersModItems.HYPER_MOB_DESIGNATOR.get()), 22500);
		}
	}
}
