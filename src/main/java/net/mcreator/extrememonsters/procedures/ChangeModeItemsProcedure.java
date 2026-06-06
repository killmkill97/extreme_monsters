package net.mcreator.extrememonsters.procedures;

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
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

public class ChangeModeItemsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack HandItem = ItemStack.EMPTY;
		HandItem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		if (HandItem.getItem() == ExtremeMonstersModItems.DRAGON_MATTER_SWORD.get() || HandItem.getItem() == ExtremeMonstersModItems.WITHER_MATTER_SWORD.get() || HandItem.getItem() == ExtremeMonstersModItems.PERFECT_MATTER_SWORD.get()) {
			if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).slash_all) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("slash monster"), true);
				{
					ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
					_vars.slash_all = false;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("slash all"), true);
				{
					ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
					_vars.slash_all = true;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (HandItem.getItem() == ExtremeMonstersModItems.TUNGSTEN_BAT.get()) {
			if (HandItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("no_attack") == true) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("attack mode"), true);
				{
					final String _tagName = "no_attack";
					final boolean _tagValue = false;
					CustomData.update(DataComponents.CUSTOM_DATA, HandItem, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = HandItem.copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("push mode"), true);
				{
					final String _tagName = "no_attack";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, HandItem, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = HandItem.copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		}
		if (HandItem.getItem() == ExtremeMonstersModItems.PERFECT_ABYSS.get()) {
			if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).perfect_abyss_despawn_mode) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("push mode"), true);
				{
					ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
					_vars.perfect_abyss_despawn_mode = false;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("eliminate mode"), true);
				{
					ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
					_vars.perfect_abyss_despawn_mode = true;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (HandItem.getItem() == ExtremeMonstersModItems.WITHERED_DARK_MATTER_LAUNCHER.get()) {
			if (HandItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Griefing") == true) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("attack mode"), true);
				{
					final String _tagName = "Griefing";
					final boolean _tagValue = false;
					CustomData.update(DataComponents.CUSTOM_DATA, HandItem, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = HandItem.copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.MASTER, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("griefing mode"), true);
				{
					final String _tagName = "Griefing";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, HandItem, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = HandItem.copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		}
	}
}
