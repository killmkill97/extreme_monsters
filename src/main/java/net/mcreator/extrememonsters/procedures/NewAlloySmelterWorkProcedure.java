package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModFluids;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class NewAlloySmelterWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "EnabledHFE"))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("EnabledHFE", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("CannotAccpetHFE", false);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("MaxHFE", 512);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				if (world instanceof ILevelExtension _ext) {
					IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
					if (_itemHandler != null)
						return _itemHandler.getStackInSlot(slotid).copy();
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 8)).getItem() == ExtremeMonstersModItems.SUPER_LAVA_BUCKET.get()) {
			if (new Object() {
				public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
					if (level instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
						if (_fluidHandler != null)
							return _fluidHandler.fill(new FluidStack(ExtremeMonstersModFluids.SUPER_LAVA.get(), amount), IFluidHandler.FluidAction.SIMULATE);
					}
					return 0;
				}
			}.fillTankSimulate(world, BlockPos.containing(x, y, z), 1000) >= 1000) {
				if (world instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
					if (_fluidHandler != null)
						_fluidHandler.fill(new FluidStack(ExtremeMonstersModFluids.SUPER_LAVA.get(), 1000), IFluidHandler.FluidAction.EXECUTE);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 8;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(8, _setstack);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
		if (new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				if (level instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
					if (_entityStorage != null)
						return _entityStorage.getEnergyStored();
				}
				return 0;
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 6500000 && new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "CurrentHFE") >= 16) {
			AlloySmelterRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_INGOT_BLOCK.get()), new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_INGOT_BLOCK.get()),
					new ItemStack(ExtremeMonstersModBlocks.INFERNO_MATTER_INGOT_BLOCK.get()), new ItemStack(ExtremeMonstersModBlocks.DRAGON_MATTER_INGOT_BLOCK.get()), new ItemStack(ExtremeMonstersModBlocks.WITHER_MATTER_INGOT_BLOCK.get()),
					new ItemStack(ExtremeMonstersModBlocks.TUNGSTEN_CRYSTAL_MATRIX_BLOCK.get()), new ItemStack(ExtremeMonstersModItems.ALLTHEMATTERIUM_INGOT.get()), 16, 6500000);
			AlloySmelterRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.MIXED_HYPER_INGOT.get()), new ItemStack(ExtremeMonstersModItems.HYPER_INGOT_3.get()),
					new ItemStack(ExtremeMonstersModItems.HYPER_DRAGON_INGOT.get()), new ItemStack(ExtremeMonstersModItems.HYPER_WITHER_INGOT.get()), new ItemStack(ExtremeMonstersModItems.STARS_SOUL.get()),
					new ItemStack(ExtremeMonstersModItems.HYPER_ENDER_WITHER_IN_THE_BOTTLE.get()), new ItemStack(ExtremeMonstersModItems.ALLTHEHYPERIUM_INGOT.get()), 16, 6500000);
			AlloySmelterRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.INFERNO_MATTER_INGOT.get()), new ItemStack(ExtremeMonstersModItems.SINGULARITY.get()),
					new ItemStack(ExtremeMonstersModItems.SUPER_MATTER_CATALYST.get()), new ItemStack(ExtremeMonstersModItems.TRACKER_CORE.get()), new ItemStack(ExtremeMonstersModItems.SUPERCHARGED_DARK_MATTER.get()),
					new ItemStack(Blocks.NETHERITE_BLOCK), new ItemStack(ExtremeMonstersModItems.MOLECULAR_ALLOY_INGOT.get()), 16, 6500000);
		}
	}
}
