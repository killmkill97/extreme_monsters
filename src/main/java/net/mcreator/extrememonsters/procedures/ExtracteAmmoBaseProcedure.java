package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class ExtracteAmmoBaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack ExtracteItem) {
		if (entity == null)
			return;
		ItemStack paste_item = ItemStack.EMPTY;
		double extracte_rate = 0;
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.OFF_HAND, true);
		paste_item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		extracte_rate = ClampToMcreatorProdProcedure.execute(paste_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ammo"), 64, 0);
		if (extracte_rate > 0) {
			{
				final String _tagName = "ammo";
				final double _tagValue = (paste_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ammo") - extracte_rate);
				CustomData.update(DataComponents.CUSTOM_DATA, paste_item, tag -> tag.putDouble(_tagName, _tagValue));
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).applyComponents(paste_item.getComponents());
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.big_fall")), SoundSource.PLAYERS, 1, (float) 1.2);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.big_fall")), SoundSource.PLAYERS, 1, (float) 1.2, false);
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = ExtracteItem.copy();
				_setstack.setCount((int) extracte_rate);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
