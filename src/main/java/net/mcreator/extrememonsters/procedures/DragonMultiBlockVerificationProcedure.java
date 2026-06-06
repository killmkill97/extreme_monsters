package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class DragonMultiBlockVerificationProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double found_number = 0;
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
				if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
						if ((world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_mining_unit2")))) {
							if ((world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_mining_unit2")))) {
								if ((world.getBlockState(BlockPos.containing(x, y + 4, z + 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_mining_unit2")))) {
									if ((world.getBlockState(BlockPos.containing(x, y + 4, z - 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_mining_unit2")))) {
										if ((world.getBlockState(BlockPos.containing(x, y + 4, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
											if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
												if ((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
													if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
														if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
															if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																if ((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																	if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																		if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																			if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																				if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																					if ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																						if ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																							if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																								if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																									if ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																										if ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 2))).getBlock() == ExtremeMonstersModBlocks.DRAGON_MINING_CASING.get()) {
																											if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z)))
																													.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_mining_unit1")))) {
																												if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z)))
																														.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_mining_unit1")))) {
																													if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 2)))
																															.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_mining_unit1")))) {
																														if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 2)))
																																.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_mining_unit1")))) {
																															sx = -1;
																															found = false;
																															for (int index0 = 0; index0 < 3; index0++) {
																																sy = -1;
																																for (int index1 = 0; index1 < 3; index1++) {
																																	sz = -1;
																																	for (int index2 = 0; index2 < 3; index2++) {
																																		if ((world.getBlockState(BlockPos.containing(x + sx, y + 2 + sy, z + sz))).getBlock() == Blocks.AIR
																																				|| (world.getBlockState(BlockPos.containing(x + sx, y + 2 + sy, z + sz)))
																																						.getBlock() == ExtremeMonstersModBlocks.FICTIONAL_PLANET.get()) {
																																			found_number = found_number + 1;
																																		}
																																		sz = sz + 1;
																																	}
																																	sy = sy + 1;
																																}
																																sx = sx + 1;
																															}
																															if (found_number == 27) {
																																return true;
																															}
																															return false;
																														}
																														return false;
																													}
																													return false;
																												}
																												return false;
																											}
																											return false;
																										}
																										return false;
																									}
																									return false;
																								}
																								return false;
																							}
																						}
																						return false;
																					}
																					return false;
																				}
																				return false;
																			}
																		}
																		return false;
																	}
																	return false;
																}
																return false;
															}
														}
														return false;
													}
													return false;
												}
												return false;
											}
											return false;
										}
										return false;
									}
								}
								return false;
							}
						}
						return false;
					}
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
