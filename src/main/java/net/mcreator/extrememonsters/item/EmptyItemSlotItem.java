
package net.mcreator.extrememonsters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item.TooltipContext;

import java.util.List;

public class EmptyItemSlotItem extends Item {
	public EmptyItemSlotItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pFlag) {
        System.out.println("EmptyItemSlotItem appendHoverText called for: " + pStack.getItem().getDescriptionId());

        // 기존 툴팁 내용을 모두 지웁니다.
        pTooltipComponents.clear();

        // 이 줄을 제거합니다: super.appendHoverText(pStack, pContext, pTooltipComponents, pFlag);
        // 부모 클래스의 메서드를 호출하지 않음으로써, 기본 툴팁 정보가 추가되는 것을 막습니다.

        System.out.println("Tooltip for empty_item_slot cleared.");
    }
}
