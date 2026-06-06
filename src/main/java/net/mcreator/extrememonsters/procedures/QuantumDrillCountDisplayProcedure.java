package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class QuantumDrillCountDisplayProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		double quantum_drill_count = 0;
		boolean no_problem = false;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_MINING_CONTROLLER.get()) {
			if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get()) {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))))) == Direction.WEST) {
					quantum_drill_count = quantum_drill_count + 1;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("quantum_drills", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					no_problem = true;
				} else {
					return "The direction of the Quantum Drill is incorrect.";
				}
			} else {
				no_problem = true;
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get()) {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))))) == Direction.EAST) {
					quantum_drill_count = quantum_drill_count + 1;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("quantum_drills", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					no_problem = true;
				} else {
					return "The direction of the Quantum Drill is incorrect.";
				}
			} else {
				no_problem = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get()) {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))))) == Direction.NORTH) {
					quantum_drill_count = quantum_drill_count + 1;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("quantum_drills", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					no_problem = true;
				} else {
					return "Quantum Drill direction is incorrect";
				}
			} else {
				no_problem = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.INFERNO_QUANTUM_DRILL.get()) {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))))) == Direction.SOUTH) {
					quantum_drill_count = quantum_drill_count + 1;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("quantum_drills", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					no_problem = true;
				} else {
					return "The direction of the Quantum Drill is incorrect.";
				}
			} else {
				no_problem = true;
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CONTROLLER.get()) {
			if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QUANTUM_DRILL.get()) {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))))) == Direction.WEST) {
					quantum_drill_count = quantum_drill_count + 1;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("quantum_drills", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					no_problem = true;
				} else {
					return "The direction of the Quantum Drill is incorrect.";
				}
			} else {
				no_problem = true;
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QUANTUM_DRILL.get()) {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))))) == Direction.EAST) {
					quantum_drill_count = quantum_drill_count + 1;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("quantum_drills", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					no_problem = true;
				} else {
					return "The direction of the Quantum Drill is incorrect.";
				}
			} else {
				no_problem = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QUANTUM_DRILL.get()) {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))))) == Direction.NORTH) {
					quantum_drill_count = quantum_drill_count + 1;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("quantum_drills", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					no_problem = true;
				} else {
					return "Quantum Drill direction is incorrect";
				}
			} else {
				no_problem = true;
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QUANTUM_DRILL.get()) {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))))) == Direction.SOUTH) {
					quantum_drill_count = quantum_drill_count + 1;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("quantum_drills", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					no_problem = true;
				} else {
					return "The direction of the Quantum Drill is incorrect.";
				}
			} else {
				no_problem = true;
			}
		}
		if (no_problem) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("quantum_drills", quantum_drill_count);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			return new java.text.DecimalFormat("##.##").format(quantum_drill_count) + " of Quantum Drills";
		}
		return "The direction of the Quantum Drill is incorrect.";
	}
}
