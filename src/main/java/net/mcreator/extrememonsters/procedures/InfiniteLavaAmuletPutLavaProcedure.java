package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class InfiniteLavaAmuletPutLavaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.PLAYERS, (float) 0.1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.PLAYERS, (float) 0.1, 1, false);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.NORTH)) {
			if ((entity.getDirection()) == Direction.SOUTH) {
				if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.LAVA || world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
					world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.LAVA.defaultBlockState(), 3);
					return;
				}
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.SOUTH)) {
			if ((entity.getDirection()) == Direction.NORTH) {
				if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.LAVA || world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
					world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.LAVA.defaultBlockState(), 3);
					return;
				}
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.WEST)) {
			if ((entity.getDirection()) == Direction.EAST) {
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.LAVA || world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
					world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.LAVA.defaultBlockState(), 3);
					return;
				}
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.EAST)) {
			if ((entity.getDirection()) == Direction.NORTH) {
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.LAVA || world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
					world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.LAVA.defaultBlockState(), 3);
					return;
				}
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.DOWN)) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.LAVA || world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.LAVA.defaultBlockState(), 3);
				return;
			}
		}
	}
}
