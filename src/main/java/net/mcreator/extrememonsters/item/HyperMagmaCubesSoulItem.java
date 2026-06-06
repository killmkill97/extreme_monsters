
package net.mcreator.extrememonsters.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.procedures.SoulGlowingEffectProcedure;
import net.mcreator.extrememonsters.procedures.NoEnchantSoulProcedure;

public class HyperMagmaCubesSoulItem extends Item {
	public HyperMagmaCubesSoulItem() {
		super(new Item.Properties().durability(500).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return SoulGlowingEffectProcedure.execute(itemstack);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		NoEnchantSoulProcedure.execute(world, itemstack);
	}
}
