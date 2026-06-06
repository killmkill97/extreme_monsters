package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

public class QuantumAnchorTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack Entangle_QE = ItemStack.EMPTY;
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				if (world instanceof ILevelExtension _ext) {
					IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
					if (_itemHandler != null)
						return _itemHandler.getStackInSlot(slotid).copy();
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == ExtremeMonstersModItems.QUANTUM_ENTANGLER.get()) {
			Entangle_QE = (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).copy();
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0)).copy();
			{
				final String _tagName = "entangle";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, Entangle_QE, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "use";
				final String _tagValue = "anchor";
				CustomData.update(DataComponents.CUSTOM_DATA, Entangle_QE, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "dimension";
				final String _tagValue = ((Level) world).dimension().location().toString();
				CustomData.update(DataComponents.CUSTOM_DATA, Entangle_QE, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "linked_block_display_name";
				final String _tagValue = (new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "block_displayName"));
				CustomData.update(DataComponents.CUSTOM_DATA, Entangle_QE, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "sx";
				final double _tagValue = x;
				CustomData.update(DataComponents.CUSTOM_DATA, Entangle_QE, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "sy";
				final double _tagValue = y;
				CustomData.update(DataComponents.CUSTOM_DATA, Entangle_QE, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "sz";
				final double _tagValue = z;
				CustomData.update(DataComponents.CUSTOM_DATA, Entangle_QE, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = Entangle_QE.copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(1, _setstack);
			}
		}
	}
}
