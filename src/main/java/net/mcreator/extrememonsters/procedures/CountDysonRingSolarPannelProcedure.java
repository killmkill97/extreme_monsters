package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class CountDysonRingSolarPannelProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double solar_panels = 0;
		if ((world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 3, y + 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 3, y + 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 3, y + 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 3, y + 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 3))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 3))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 3))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 3))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 3))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 3))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_SOLAR_PANEL.get()) {
			solar_panels = solar_panels + 1;
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("SolarPanels", solar_panels);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
