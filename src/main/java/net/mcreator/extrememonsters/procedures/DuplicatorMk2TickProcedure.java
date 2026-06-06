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

public class DuplicatorMk2TickProcedure {
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
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 40000) {
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()), new ItemStack(ExtremeMonstersModItems.DUPLICATED_BLACK_HOLE_MATTER.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.DARK_MATTER_FELLET.get()), new ItemStack(ExtremeMonstersModItems.DUPLICATED_DARK_MATTER_PELLET.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_SHARD.get()), new ItemStack(ExtremeMonstersModItems.DUPLICATED_MATTER_CATALYST_SHARD.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.INFERNO_MATTER.get()), new ItemStack(ExtremeMonstersModItems.DUPLICATED_INFERNO_MATTER.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(Items.IRON_INGOT), new ItemStack(ExtremeMonstersModItems.DUPLICATED_IRON_INGOT.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(Items.GOLD_INGOT), new ItemStack(ExtremeMonstersModItems.DUPLICATED_GOLD_INGOT.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(Items.DIAMOND), new ItemStack(ExtremeMonstersModItems.DUPLICATED_DIAMOND.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(Blocks.DRAGON_EGG), new ItemStack(ExtremeMonstersModItems.DUPLICATED_DRAGON_EGG_CHUNK.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.STARS_SOUL.get()), new ItemStack(ExtremeMonstersModItems.DUPLICATED_SOUL.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(Items.NETHER_STAR), new ItemStack(ExtremeMonstersModItems.DUPLICATED_NETHER_STAR.get()), 32, 40000);
			DuplicatorBaseWorkProcedure.execute(world, x, y, z, new ItemStack(Items.LEATHER), new ItemStack(ExtremeMonstersModItems.DUPLICATED_LEATHER.get()), 32, 40000);
		}
	}
}
