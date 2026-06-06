package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class DysonRingMultiBlockVerificationProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sub_y = 0;
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()
					&& (world.getBlockState(BlockPos.containing(x, y + 4, z + 1))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()
					&& (world.getBlockState(BlockPos.containing(x, y + 4, z - 1))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()) {
				if ((world.getBlockState(BlockPos.containing(x, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_IGNITER.get()) {
					if ((world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
							&& (world.getBlockState(BlockPos.containing(x + 3, y + 2, z + 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
							&& (world.getBlockState(BlockPos.containing(x + 3, y + 2, z - 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))) {
						if ((world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z + 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z - 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))) {
							if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 3))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
									&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 3))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
									&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 3))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))) {
								if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 3))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
										&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 3))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
										&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 3))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))) {
									if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z + 2))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
											&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 2))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
											&& (world.getBlockState(BlockPos.containing(x + 2, y + 2, z - 2))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))
											&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 2))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dyson_ring_unit")))) {
										if ((world.getBlockState(BlockPos.containing(x + 2, y + 3, z + 3))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 3, z + 3))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
												&& (world.getBlockState(BlockPos.containing(x + 2, y + 3, z - 3))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 3, z - 3))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 3, z + 2))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 3, z - 2))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
												&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z + 2))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
												&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z - 2))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()) {
											if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z + 3))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
													&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 3))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
													&& (world.getBlockState(BlockPos.containing(x + 2, y + 2, z - 3))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
													&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 3))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
													&& (world.getBlockState(BlockPos.containing(x + 3, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
													&& (world.getBlockState(BlockPos.containing(x + 3, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
													&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
													&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
												if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 3))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
														&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 3))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
														&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 3))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
														&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 3))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
														&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 2))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
														&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 2))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
														&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 2))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()
														&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 2))).getBlock() == ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()) {
													if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.ARTIFICIAL_NEUTRON_STAR.get()) {
														return true;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
