package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class QssMutiBlockVerificationProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()) {
				if ((world.getBlockState(BlockPos.containing(x + 1, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CASING.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_OUTPUT_BLOCK.get()) {//변 유닛 검사 (사각형의 변 입니다)
						//side unit verification
						if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
								&& (world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
								&& (world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))) {
							if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
									&& (world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
									&& (world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))) {
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
										&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
										&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))) {
									if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
											&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
											&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))) {//코너 유닛 검사
										//coner unit verification
										if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
												&& (world.getBlockState(BlockPos.containing(x + 5, y - 1, z + 4))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
												&& (world.getBlockState(BlockPos.containing(x + 4, y - 1, z + 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))) {
											if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
													&& (world.getBlockState(BlockPos.containing(x - 5, y - 1, z - 4))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
													&& (world.getBlockState(BlockPos.containing(x - 4, y - 1, z - 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))) {
												if ((world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
														&& (world.getBlockState(BlockPos.containing(x + 5, y - 1, z - 4))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
														&& (world.getBlockState(BlockPos.containing(x + 4, y - 1, z - 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))) {
													if ((world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
															&& (world.getBlockState(BlockPos.containing(x - 5, y - 1, z + 4))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))
															&& (world.getBlockState(BlockPos.containing(x - 4, y - 1, z + 5))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:qss_unit")))) {
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
