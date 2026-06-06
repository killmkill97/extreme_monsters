package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class InfiniteLavaSourceFillLavaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 2147483647), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 2147483647), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x + 1, y, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 2147483647), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x - 1, y, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 2147483647), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y + 1, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 2147483647), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y - 1, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 2147483647), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z + 1), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 2147483647), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z - 1), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 2147483647), IFluidHandler.FluidAction.EXECUTE);
		}
	}
}
