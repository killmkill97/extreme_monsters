package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class MvsMultiBlockVerificationProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_INGOT_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_INGOT_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_INGOT_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_INGOT_BLOCK.get()) {
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()) {
				if ((world.getBlockState(BlockPos.containing(x + 3, y + 1, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()) {
					if ((world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
							&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
							&& (world.getBlockState(BlockPos.containing(x, y + 2, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
							&& (world.getBlockState(BlockPos.containing(x, y + 2, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()) {
						if ((world.getBlockState(BlockPos.containing(x + 3, y + 3, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:microverse_unit")))
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:microverse_unit")))
								&& (world.getBlockState(BlockPos.containing(x, y + 3, z + 3))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:microverse_unit")))
								&& (world.getBlockState(BlockPos.containing(x, y + 3, z - 3))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:microverse_unit")))) {
							if ((world.getBlockState(BlockPos.containing(x + 3, y + 3, z + 1))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
									&& (world.getBlockState(BlockPos.containing(x + 3, y + 3, z + 2))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
									&& (world.getBlockState(BlockPos.containing(x + 3, y + 3, z - 1))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
									&& (world.getBlockState(BlockPos.containing(x + 3, y + 3, z - 2))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
									&& (world.getBlockState(BlockPos.containing(x + 1, y + 3, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
									&& (world.getBlockState(BlockPos.containing(x + 2, y + 3, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
									&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
									&& (world.getBlockState(BlockPos.containing(x - 2, y + 3, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()) {
								if ((world.getBlockState(BlockPos.containing(x - 3, y + 3, z + 1))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
										&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z + 2))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
										&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z - 1))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
										&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z - 2))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
										&& (world.getBlockState(BlockPos.containing(x + 1, y + 3, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
										&& (world.getBlockState(BlockPos.containing(x + 2, y + 3, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
										&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
										&& (world.getBlockState(BlockPos.containing(x - 2, y + 3, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()) {
									if ((world.getBlockState(BlockPos.containing(x + 3, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
											&& (world.getBlockState(BlockPos.containing(x - 3, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
											&& (world.getBlockState(BlockPos.containing(x, y + 4, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
											&& (world.getBlockState(BlockPos.containing(x, y + 4, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()) {
										if ((world.getBlockState(BlockPos.containing(x + 3, y + 5, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
												&& (world.getBlockState(BlockPos.containing(x - 3, y + 5, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
												&& (world.getBlockState(BlockPos.containing(x, y + 5, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
												&& (world.getBlockState(BlockPos.containing(x, y + 5, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()) {
											if ((world.getBlockState(BlockPos.containing(x + 2, y + 6, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
													&& (world.getBlockState(BlockPos.containing(x - 2, y + 6, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
													&& (world.getBlockState(BlockPos.containing(x, y + 6, z + 2))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()
													&& (world.getBlockState(BlockPos.containing(x, y + 6, z - 2))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_CASING.get()) {
												if ((world.getBlockState(BlockPos.containing(x + 1, y + 6, z))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
														&& (world.getBlockState(BlockPos.containing(x - 1, y + 6, z))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
														&& (world.getBlockState(BlockPos.containing(x, y + 6, z + 1))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()
														&& (world.getBlockState(BlockPos.containing(x, y + 6, z - 1))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
													if ((world.getBlockState(BlockPos.containing(x, y + 6, z))).getBlock() == ExtremeMonstersModBlocks.WITHER_MACHINE_FRAME.get()) {
														if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()
																&& (world.getBlockState(BlockPos.containing(x - 3, y, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()
																&& (world.getBlockState(BlockPos.containing(x + 3, y, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()
																&& (world.getBlockState(BlockPos.containing(x - 3, y, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()) {
															if ((world.getBlockState(BlockPos.containing(x + 3, y + 6, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()
																	&& (world.getBlockState(BlockPos.containing(x - 3, y + 6, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()
																	&& (world.getBlockState(BlockPos.containing(x + 3, y + 6, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()
																	&& (world.getBlockState(BlockPos.containing(x - 3, y + 6, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()) {
																sx = -2;
																found = false;
																for (int index0 = 0; index0 < 5; index0++) {
																	sy = -2;
																	for (int index1 = 0; index1 < 5; index1++) {
																		sz = -2;
																		for (int index2 = 0; index2 < 5; index2++) {
																			if (!((world.getBlockState(BlockPos.containing(x + sx, y + 3 + sy, z + sz))).getBlock() == Blocks.AIR)) {
																				found = true;
																			}
																			sz = sz + 1;
																		}
																		sy = sy + 1;
																	}
																	sx = sx + 1;
																}
																if (found == true) {
																	return false;
																}
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
			}
		}
		return false;
	}
}
