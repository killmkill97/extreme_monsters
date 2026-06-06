package net.mcreator.extrememonsters;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;

public class EMItemHandler extends ItemStackHandler {
    private final boolean[] canInsert;
    private final boolean[] canExtract;

    public EMItemHandler(int slots, boolean[] canInsert, boolean[] canExtract) {
        super(slots);
        if (canInsert.length != slots || canExtract.length != slots) {
            throw new IllegalArgumentException("슬롯 수와 플래그 배열 길이가 다름");
        }
        this.canInsert = canInsert.clone();
        this.canExtract = canExtract.clone();
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        if (!canInsert[slot]) {
            return stack;
        }
        return super.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (!canExtract[slot]) {
            return ItemStack.EMPTY;
        }
        return super.extractItem(slot, amount, simulate);
    }
}


