package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class SkyLightDiplayProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -3;
		found = false;
		for (int index0 = 0; index0 < 7; index0++) {
			sy = -3;
			for (int index1 = 0; index1 < 7; index1++) {
				sz = -3;
				for (int index2 = 0; index2 < 7; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == ExtremeMonstersModBlocks.ARTIFICIAL_SUN.get()) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found == true) {
			return "15 / 15 of the sky light(solar light)";
		}
		if (world instanceof Level _lvl2 && _lvl2.isDay()) {
			return new java.text.DecimalFormat("##.##").format(world.getBrightness(LightLayer.SKY, BlockPos.containing(x, y + 1, z))) + " / " + "15" + " of the sky light(solar light)";
		}
		return "0 / 15 of the sky light(solar light)";
	}
}
