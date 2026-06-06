package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class AppleCultivatorMK1WorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(Blocks.OAK_SAPLING), new ItemStack(Items.APPLE), 30000, 80);
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_SAPLING.get()), new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_APPLE.get()), 40000, 40);
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_SAPLING.get()), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_APPLE.get()), 50000, 10);
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.INFERNO_MATTER_SAPLING.get()), new ItemStack(ExtremeMonstersModItems.INFERNO_MATTER_APPLE.get()), 60000, 5);
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.GOLDEN_SAPLING.get()), new ItemStack(Items.GOLDEN_APPLE), 20000, 160);
		if (!(new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "success")) && new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "progress") > 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("progress", ClampToMcreatorProdProcedure.execute((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "progress")) - 80, 1800, 0));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
