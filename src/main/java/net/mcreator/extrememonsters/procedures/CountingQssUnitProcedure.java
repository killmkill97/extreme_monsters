package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class CountingQssUnitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double stabil_count = 0;
		double qubitmem_conut = 0;
		double errsov_count = 0;
		//변 유닛 카운팅 (사각형의 변 입니다)
		if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 6))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		} //코너 유닛 카운팅
		if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 4, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 4, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 4, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 4, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 4, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 4, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x + 4, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 4, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x + 4, y - 1, z - 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 4))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x - 4, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_STABILIZER.get()) {
			stabil_count = stabil_count + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 4, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_QUBIT_MEMORY.get()) {
			qubitmem_conut = qubitmem_conut + 1;
		} else if ((world.getBlockState(BlockPos.containing(x - 4, y - 1, z + 5))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_ERROR_SOLVER.get()) {
			errsov_count = errsov_count + 1;
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("stabil_count", stabil_count);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("qubitmem_count", qubitmem_conut);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("errsov_count", errsov_count);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
