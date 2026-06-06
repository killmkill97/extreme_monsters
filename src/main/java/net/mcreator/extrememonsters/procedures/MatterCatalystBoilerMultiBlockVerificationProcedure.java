package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class MatterCatalystBoilerMultiBlockVerificationProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
					&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
					&& (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
					&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()) {
				if ((world.getBlockState(BlockPos.containing(x + 1, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y - 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_HEAT_CONDUCTION_COIL.get()) {
					if ((world.getBlockState(BlockPos.containing(x + 1, y - 3, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
							&& (world.getBlockState(BlockPos.containing(x - 1, y - 3, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
							&& (world.getBlockState(BlockPos.containing(x + 1, y - 3, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
							&& (world.getBlockState(BlockPos.containing(x - 1, y - 3, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()
							&& (world.getBlockState(BlockPos.containing(x + 1, y - 3, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:boiler_unit")))
							&& (world.getBlockState(BlockPos.containing(x - 1, y - 3, z))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:boiler_unit")))
							&& (world.getBlockState(BlockPos.containing(x, y - 3, z + 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:boiler_unit")))
							&& (world.getBlockState(BlockPos.containing(x, y - 3, z - 1))).is(BlockTags.create(ResourceLocation.parse("extreme_monsters:boiler_unit")))) {
						if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_SOLAR_PANEL.get()
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_SOLAR_PANEL.get()
								&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_SOLAR_PANEL.get()
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_SOLAR_PANEL.get()) {
							if (((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.ARTIFICIAL_SUN.get()
									|| (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == ExtremeMonstersModBlocks.ARTIFICIAL_NEUTRON_STAR.get())
									&& (world.getBlockState(BlockPos.containing(x, y - 3, z))).getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_BOILER_CASING.get()) {
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
}
