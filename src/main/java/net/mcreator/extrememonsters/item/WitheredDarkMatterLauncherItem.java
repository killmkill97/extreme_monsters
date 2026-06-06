
package net.mcreator.extrememonsters.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.extrememonsters.procedures.WitheredDarkMatterLunacherGriefingModeGlowingProcedure;

import java.util.List;

public class WitheredDarkMatterLauncherItem extends Item {
	public WitheredDarkMatterLauncherItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return WitheredDarkMatterLunacherGriefingModeGlowingProcedure.execute(itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.extreme_monsters.withered_dark_matter_launcher.description_0"));
		list.add(Component.translatable("item.extreme_monsters.withered_dark_matter_launcher.description_1"));
	}
}
