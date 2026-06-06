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

public class DarkMatterAssemblerWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < 2; index0++) {
			AssemblerWorkProcedure.execute(world, x, y, z);
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
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 1800) {
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.SPEED_UPGRADE_1.get()), new ItemStack(ExtremeMonstersModItems.DARK_MATTER.get()), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST.get()),
					new ItemStack(ExtremeMonstersModItems.HYPER_ROTTEN_FLESH.get()), new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR), new ItemStack(ExtremeMonstersModItems.SPEED_UPGRADE_2.get()), 1800);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_2.get()),
					new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST.get()), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_FUEL.get()), new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK_2X.get()),
					new ItemStack(ExtremeMonstersModBlocks.DUPLICATED_BEDROCK.get()), new ItemStack(ExtremeMonstersModItems.MIXED_HYPER_ESSENCE.get()), 1800);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.DARK_MATTER.get()), new ItemStack(ExtremeMonstersModBlocks.SUPER_MAGMA.get()), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_SHARD.get()),
					new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_FUEL.get()), new ItemStack(ExtremeMonstersModItems.HYPER_GOLD_NUGGET.get()), new ItemStack(Blocks.AIR), new ItemStack(ExtremeMonstersModItems.INFERNO_MATTER.get()), 1800);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.ADVANCED_MACHINE_FRAME.get()), new ItemStack(Blocks.GOLD_BLOCK), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST.get()),
					new ItemStack(ExtremeMonstersModItems.HYPER_SPIDER_EYE.get()), new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR), new ItemStack(ExtremeMonstersModBlocks.CLEVER_MACHINE_FRAME.get()), 1800);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_INGOT.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()),
					new ItemStack(ExtremeMonstersModBlocks.HYPER_STONE.get()), new ItemStack(Items.NETHER_STAR), new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_BLOCK.get()), new ItemStack(Blocks.AIR),
					new ItemStack(ExtremeMonstersModItems.SUPER_MATTER_CATALYST.get()), 1800);
			AssemblerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.TRACKER_IN_THE_BOTTLE.get()), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST.get()),
					new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_BLOCK.get()), new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(Blocks.AIR), new ItemStack(Blocks.AIR), new ItemStack(ExtremeMonstersModItems.HYPER_TRACKER_IN_THE_BOTTLE.get()),
					1800);
		}
	}
}
