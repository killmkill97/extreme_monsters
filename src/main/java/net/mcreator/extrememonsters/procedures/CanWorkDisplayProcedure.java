package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class CanWorkDisplayProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 4, y, z))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_INFUSER.get() && (new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x + 4, y, z))))) == Direction.WEST) {
			if ((world.getBlockState(BlockPos.containing(x - 4, y, z))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_INFUSER.get() && (new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection((world.getBlockState(BlockPos.containing(x - 4, y, z))))) == Direction.EAST) {
				if ((world.getBlockState(BlockPos.containing(x, y, z + 4))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_INFUSER.get() && (new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y, z + 4))))) == Direction.NORTH) {
					if ((world.getBlockState(BlockPos.containing(x, y, z - 4))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_INFUSER.get() && (new Object() {
						public Direction getDirection(BlockState _bs) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp)
								return _bs.getValue(_dp);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
									? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
									: Direction.NORTH;
						}
					}.getDirection((world.getBlockState(BlockPos.containing(x, y, z - 4))))) == Direction.SOUTH) {
						if ((world.getBlockState(BlockPos.containing(x + 4, y, z + 4))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
							if ((world.getBlockState(BlockPos.containing(x - 4, y, z + 4))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
								if ((world.getBlockState(BlockPos.containing(x + 4, y, z - 4))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
									if ((world.getBlockState(BlockPos.containing(x - 4, y, z - 4))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
										if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _getbp29
												&& (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp29)) {
											return "Work in progress";
										} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("can_work") instanceof BooleanProperty _getbp31
												&& (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp31)) {
											return "Ready to craft";
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return "Invalid Structure!";
	}
}
