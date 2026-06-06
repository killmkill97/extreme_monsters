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

public class AppleCultivatorMk2Work2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(Blocks.OAK_SAPLING), new ItemStack(Items.APPLE), 3250000, 160);
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_SAPLING.get()), new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_APPLE.get()), 3350000, 80);
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_SAPLING.get()), new ItemStack(ExtremeMonstersModItems.DARK_MATTER_APPLE.get()), 3450000, 20);
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.INFERNO_MATTER_SAPLING.get()), new ItemStack(ExtremeMonstersModItems.INFERNO_MATTER_APPLE.get()), 3500000, 10);
		AppleCultivatorRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.GOLDEN_SAPLING.get()), new ItemStack(Items.GOLDEN_APPLE), 3000000, 320);
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
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("success", false);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
