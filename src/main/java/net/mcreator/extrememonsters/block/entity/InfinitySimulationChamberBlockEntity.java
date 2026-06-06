package net.mcreator.extrememonsters.block.entity;

import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.energy.EnergyStorage;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.world.inventory.InfinitySimulationChamberGUIMenu;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlockEntities;
import net.mcreator.extrememonsters.EMItemHandler;

import javax.annotation.Nullable;

import java.util.stream.IntStream;

import io.netty.buffer.Unpooled;

public class InfinitySimulationChamberBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private final EMItemHandler inventory = new EMItemHandler(
	    5, //원하는 슬롯수
	    new boolean[]{ true, false, false, false, false},      // canInsert
	    new boolean[]{ false, true, false, false, false} // canExtract
	);

	public InfinitySimulationChamberBlockEntity(BlockPos position, BlockState state) {
		super(ExtremeMonstersModBlockEntities.INFINITY_SIMULATION_CHAMBER.get(), position, state);
	}

	@Override
	public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.loadAdditional(compound, lookupProvider);
		if (!this.tryLoadLootTable(compound)) {
		    NonNullList<ItemStack> tmp = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		    ContainerHelper.loadAllItems(compound, tmp, lookupProvider);
		    this.setItems(tmp); // 아래에서 구현할 setItems()로 EMItemHandler에 밀어넣기
		}
		if (compound.get("energyStorage") instanceof IntTag intTag)
			energyStorage.deserializeNBT(lookupProvider, intTag);
	}

	@Override
	public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.saveAdditional(compound, lookupProvider);
		if (!this.trySaveLootTable(compound)) {
		    NonNullList<ItemStack> tmp = this.getItems(); // 아래에서 구현할 getItems()
		    ContainerHelper.saveAllItems(compound, tmp, lookupProvider);
		}
		compound.put("energyStorage", energyStorage.serializeNBT(lookupProvider));
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
		return this.saveWithFullMetadata(lookupProvider);
	}

	@Override
	public int getContainerSize() {
	    return inventory.getSlots();
	}
	
	@Override
	public boolean isEmpty() {
	    for (int i = 0; i < inventory.getSlots(); i++) {
	        if (!inventory.getStackInSlot(i).isEmpty())
	            return false;
	    }
	    return true;
	}

	@Override
	public Component getDefaultName() {
		return Component.literal("infinity_simulation_chamber");
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}
	@Override
	public ItemStack removeItem(int index, int count) {
	    ItemStack stack = inventory.getStackInSlot(index);
	    if (stack.isEmpty()) {
	        return ItemStack.EMPTY;
	    }
	
	    ItemStack result;
	    if (stack.getCount() <= count) {
	        // 전부 가져가기
	        result = stack;
	        inventory.setStackInSlot(index, ItemStack.EMPTY);
	    } else {
	        // 일부만 가져가기
	        result = stack.copy();
	        result.setCount(count);
	        stack.shrink(count);
	        inventory.setStackInSlot(index, stack);
	    }
	
	    setChanged();
	    return result;
	}
	
	@Override
	public ItemStack removeItemNoUpdate(int index) {
	    ItemStack stack = inventory.getStackInSlot(index);
	    if (stack.isEmpty()) {
	        return ItemStack.EMPTY;
	    }
	    inventory.setStackInSlot(index, ItemStack.EMPTY);
	    return stack;
	}
	
	
	@Override
	public void setItem(int index, ItemStack stack) {
	    inventory.setStackInSlot(index, stack);
	    if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
	        stack.setCount(this.getMaxStackSize());
	    }
	    setChanged();
	}
	
	@Override
	public void clearContent() {
	    for (int i = 0; i < inventory.getSlots(); i++) {
	        inventory.setStackInSlot(i, ItemStack.EMPTY);
	    }
	}
	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new InfinitySimulationChamberGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("§4Infinity Simulation Chamber");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
	    NonNullList<ItemStack> list = NonNullList.withSize(inventory.getSlots(), ItemStack.EMPTY);
	    for (int i = 0; i < inventory.getSlots(); i++) {
	        list.set(i, inventory.getStackInSlot(i));
	    }
	    return list;
	}
	
	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
	    for (int i = 0; i < stacks.size() && i < inventory.getSlots(); i++) {
	        inventory.setStackInSlot(i, stacks.get(i));
	    }
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		if (index == 1)
			return false;
		return true;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		if (index == 0)
			return false;
		if (index == 2)
			return false;
		if (index == 3)
			return false;
		return true;
	}

	public EMItemHandler getItemHandler() {
	    return inventory;
	}
	
	private final EnergyStorage energyStorage = new EnergyStorage(10000000, 2147483647, 2147483647, 0) {
		@Override
		public int receiveEnergy(int maxReceive, boolean simulate) {
			int retval = super.receiveEnergy(maxReceive, simulate);
			if (!simulate) {
				setChanged();
				level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 2);
			}
			return retval;
		}

		@Override
		public int extractEnergy(int maxExtract, boolean simulate) {
			int retval = super.extractEnergy(maxExtract, simulate);
			if (!simulate) {
				setChanged();
				level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 2);
			}
			return retval;
		}
	};

	public EnergyStorage getEnergyStorage() {
		return energyStorage;
	}
}
