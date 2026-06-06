package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class OutputsMicroverseOutputProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack output_item = ItemStack.EMPTY;
		double OutpuSlot = 0;
		double LoopSlot = 0;
		double random_output_count = 0;
		double InputBlockX = 0;
		double InputBlockY = 0;
		double InputBlockZ = 0;
		double OurpurBlockX = 0;
		double OurpurBlockY = 0;
		double OurpurBlockZ = 0;
		if ((world.getBlockState(BlockPos.containing(x + 3, y + 3, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_INPUT_BLOCK.get()) {
			InputBlockX = x + 3;
			InputBlockY = y + 3;
			InputBlockZ = z;
		} else if ((world.getBlockState(BlockPos.containing(x - 3, y + 3, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_INPUT_BLOCK.get()) {
			InputBlockX = x - 3;
			InputBlockY = y + 3;
			InputBlockZ = z;
		} else if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_INPUT_BLOCK.get()) {
			InputBlockX = x;
			InputBlockY = y + 3;
			InputBlockZ = z + 3;
		} else if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_INPUT_BLOCK.get()) {
			InputBlockX = x;
			InputBlockY = y + 3;
			InputBlockZ = z - 3;
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.BLOCKS, (float) 0.2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.BLOCKS, (float) 0.2, 1, false);
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 3, y + 3, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_ITEM_OUTPUT_BLOCK.get()) {
			OurpurBlockX = x + 3;
			OurpurBlockY = y + 3;
			OurpurBlockZ = z;
		} else if ((world.getBlockState(BlockPos.containing(x - 3, y + 3, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_ITEM_OUTPUT_BLOCK.get()) {
			OurpurBlockX = x - 3;
			OurpurBlockY = y + 3;
			OurpurBlockZ = z;
		} else if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_ITEM_OUTPUT_BLOCK.get()) {
			OurpurBlockX = x;
			OurpurBlockY = y + 3;
			OurpurBlockZ = z + 3;
		} else if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 3))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_ITEM_OUTPUT_BLOCK.get()) {
			OurpurBlockX = x;
			OurpurBlockY = y + 3;
			OurpurBlockZ = z - 3;
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.BLOCKS, (float) 0.2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.BLOCKS, (float) 0.2, 1, false);
				}
			}
		}
		for (int index0 = 0; index0 < 32; index0++) {
			LoopSlot = 1;
			for (int index1 = 0; index1 < 9; index1++) {
				if (!((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack(world, BlockPos.containing(InputBlockX, InputBlockY, InputBlockZ), (int) LoopSlot)).getItem() == Blocks.AIR.asItem())) {
					output_item = GetSchemaItemProcedure.execute(new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							if (world instanceof ILevelExtension _ext) {
								IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(slotid).copy();
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack(world, BlockPos.containing(InputBlockX, InputBlockY, InputBlockZ), (int) LoopSlot)).copy();
					OutpuSlot = FindOutputSlot2Procedure.execute(world, output_item, 64, 27, 0, OurpurBlockX, OurpurBlockY, OurpurBlockZ);
					if (OutpuSlot != -1) {
						if (SchemaUseElementProcedure.execute(world, x, y, z, new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(InputBlockX, InputBlockY, InputBlockZ), (int) LoopSlot))) {
							if ((new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).copy();
									}
									return ItemStack.EMPTY;
								}
							}.getItemStack(world, BlockPos.containing(OurpurBlockX, OurpurBlockY, OurpurBlockZ), (int) OutpuSlot)).getItem() == Blocks.AIR.asItem()) {
								if (world instanceof ILevelExtension _ext
										&& _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(OurpurBlockX, OurpurBlockY, OurpurBlockZ), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = output_item.copy();
									_setstack.setCount(1);
									_itemHandlerModifiable.setStackInSlot((int) OutpuSlot, _setstack);
								}
							} else {
								if (world instanceof ILevelExtension _ext
										&& _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(OurpurBlockX, OurpurBlockY, OurpurBlockZ), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = output_item.copy();
									_setstack.setCount((int) ((new Object() {
										public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
											if (world instanceof ILevelExtension _ext) {
												IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
												if (_itemHandler != null)
													return _itemHandler.getStackInSlot(slotid).copy();
											}
											return ItemStack.EMPTY;
										}
									}.getItemStack(world, BlockPos.containing(OurpurBlockX, OurpurBlockY, OurpurBlockZ), (int) OutpuSlot)).getCount() + 1));
									_itemHandlerModifiable.setStackInSlot((int) OutpuSlot, _setstack);
								}
							}
						}
					}
				}
				LoopSlot = LoopSlot + 1;
			}
		}
	}
}
