package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class InfiniteCobblestoneSourceTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double slot = 0;
		slot = 0;
		for (int index0 = 0; index0 < 256; index0++) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(Blocks.COBBLESTONE).copy();
				_setstack.setCount(64);
				_itemHandlerModifiable.setStackInSlot((int) slot, _setstack);
			}
			slot = slot + 1;
		}
	}
}
