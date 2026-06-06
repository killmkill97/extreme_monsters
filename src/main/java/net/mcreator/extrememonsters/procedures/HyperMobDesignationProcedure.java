package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperMobDesignationProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		boolean break_hyper_mob_designator = false;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.HYPER_MOB_DESIGNATOR.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.DISPOSABLE_HYPER_MOB_DESIGNATOR.get()) {
			if (entity instanceof WitherBoss) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.HYPER_MOB_DESIGNATOR.get()) {
					entity.setCustomName(Component.literal("\u00A74Hyper Wither"));
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("was successfully assigned"), true);
					if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
						_livingEntity10.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
					if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity11.getAttribute(Attributes.MAX_HEALTH).setBaseValue(1000);
					if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.ARMOR))
						_livingEntity12.getAttribute(Attributes.ARMOR).setBaseValue(30);
					if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
						_livingEntity13.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(30);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(1000);
				} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.DISPOSABLE_HYPER_MOB_DESIGNATOR.get()) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("can't designation this item"), true);
				}
			} else if (entity instanceof EnderDragon) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.HYPER_MOB_DESIGNATOR.get()) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("was successfully assigned"), true);
					if (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
						_livingEntity23.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
					if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity24.getAttribute(Attributes.MAX_HEALTH).setBaseValue(500);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(500);
				} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.DISPOSABLE_HYPER_MOB_DESIGNATOR.get()) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("can't designation this item"), true);
				}
			} else if (entity instanceof MagmaCube) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.HYPER_MOB_DESIGNATOR.get()) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("was successfully assigned"), true);
					if (entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
						_livingEntity34.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
					if (entity instanceof LivingEntity _livingEntity35 && _livingEntity35.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity35.getAttribute(Attributes.MAX_HEALTH).setBaseValue(750);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(750);
				} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.DISPOSABLE_HYPER_MOB_DESIGNATOR.get()) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("can't designation this item"), true);
				}
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("c:hypermob_tier2")))) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("was successfully assigned"), true);
				if (entity instanceof LivingEntity _livingEntity43 && _livingEntity43.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
					_livingEntity43.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
				if (entity instanceof LivingEntity _livingEntity44 && _livingEntity44.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
					_livingEntity44.getAttribute(Attributes.MAX_HEALTH).setBaseValue(300);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(300);
				break_hyper_mob_designator = true;
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("c:hypermob_tier1")))) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("was successfully assigned"), true);
				if (entity instanceof LivingEntity _livingEntity49 && _livingEntity49.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
					_livingEntity49.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
				if (entity instanceof LivingEntity _livingEntity50 && _livingEntity50.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
					_livingEntity50.getAttribute(Attributes.MAX_HEALTH).setBaseValue(200);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(200);
				break_hyper_mob_designator = true;
			}
			if (break_hyper_mob_designator) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.DISPOSABLE_HYPER_MOB_DESIGNATOR.get()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (sourceentity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			}
		}
	}
}
