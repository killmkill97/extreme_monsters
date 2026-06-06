
package net.mcreator.extrememonsters.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.extrememonsters.procedures.EbhmaEffectProcedure;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

public class EternalBlackHoleMatterAppleItem extends Item {
	public EternalBlackHoleMatterAppleItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(15).saturationModifier(15f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(ExtremeMonstersModItems.ETERNAL_BLACK_HOLE_MATTER_APPLE.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		EbhmaEffectProcedure.execute(entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}
