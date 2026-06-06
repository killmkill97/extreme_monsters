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

public class MolecularMatterResynthesizerTickProcedure {
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
					_blockEntity.getPersistentData().putDouble("MaxHFE", 750);
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
		}.getItemStack(world, BlockPos.containing(x, y, z), 6)).getItem() == ExtremeMonstersModItems.MOLECULAR_SOLVENT_BUCKET.get()) {
			if (new Object() {
				public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
					if (level instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
						if (_fluidHandler != null)
							return _fluidHandler.fill(new FluidStack(ExtremeMonstersModFluids.MOLECULAR_SOLVENT.get(), amount), IFluidHandler.FluidAction.SIMULATE);
					}
					return 0;
				}
			}.fillTankSimulate(world, BlockPos.containing(x, y, z), 1000) >= 1000) {
				if (world instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
					if (_fluidHandler != null)
						_fluidHandler.fill(new FluidStack(ExtremeMonstersModFluids.MOLECULAR_SOLVENT.get(), 1000), IFluidHandler.FluidAction.EXECUTE);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 6;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(6, _setstack);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.BLOCKS, 1, 1, false);
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
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 2812500 && new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "CurrentHFE") >= 12 && new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				if (level instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
					if (_fluidHandler != null)
						return _fluidHandler.getFluidInTank(tank).getAmount();
				}
				return 0;
			}
		}.getFluidTankLevel(world, BlockPos.containing(x, y, z), 1) >= 100) {
			MolecularMatterResynthesizerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_DRAGON_SKIN.get()), new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_BLOCK.get()),
					new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENDER_PEARL.get()), new ItemStack(ExtremeMonstersModItems.DRAGON_MATTER.get()), 12, 8, 2812500);
			MolecularMatterResynthesizerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_ENDER_DRAGON_IN_THE_BOTTLE.get()), new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_BLOCK.get()),
					new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENDER_PEARL.get()), new ItemStack(ExtremeMonstersModItems.DRAGON_MATTER.get()), 12, 4, 2812500);
			MolecularMatterResynthesizerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_NETHER_STAR.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()),
					new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_2.get()), new ItemStack(ExtremeMonstersModItems.DRAGON_MATTER.get()), new ItemStack(ExtremeMonstersModItems.WITHER_MATTER.get()), 12, 8, 2812500);
			MolecularMatterResynthesizerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_WITHER_IN_THE_BOTTLE.get()), new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()),
					new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_2.get()), new ItemStack(ExtremeMonstersModItems.DRAGON_MATTER.get()), new ItemStack(ExtremeMonstersModItems.WITHER_MATTER.get()), 12, 4, 2812500);
			MolecularMatterResynthesizerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_MAGMA_CREAM.get()), new ItemStack(Blocks.MAGMA_BLOCK), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST.get()),
					new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_BLOCK.get()), new ItemStack(ExtremeMonstersModBlocks.SUPER_MAGMA.get()), 12, 12, 2812500);
			MolecularMatterResynthesizerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_INGOT_BLOCK.get()), new ItemStack(ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK_3X.get()),
					new ItemStack(ExtremeMonstersModBlocks.NETHER_STAR_BLOCK.get()), new ItemStack(ExtremeMonstersModBlocks.INFERNO_ENERGY_CUBE.get()), new ItemStack(ExtremeMonstersModItems.SUPERCHARGED_DARK_MATTER.get()), 12, 2, 2812500);
			MolecularMatterResynthesizerRecipeBaseProcedure.execute(world, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_TRACKER_IN_THE_BOTTLE.get()), new ItemStack(ExtremeMonstersModBlocks.DARK_MATTER_BLOCK.get()),
					new ItemStack(ExtremeMonstersModItems.HYPER_ENSSENCE_1.get()), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_INGOT.get()), new ItemStack(ExtremeMonstersModItems.TRACKER_CORE.get()), 12, 2, 2812500);
		}
	}
}
