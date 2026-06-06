package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.registries.Registries;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SuperWitherSkeletonProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (ExtremeMonstersConfigurationConfiguration.HYPER_MOB_SPAWN.get()) {
			if (ExtremeMonstersModVariables.MapVariables.get(world).Extreme) {
				if (entity instanceof WitherSkeleton) {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_ARMOR_BOOTS.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_ARMOR_LEGGINGS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_ARMOR_LEGGINGS.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER_ARMOR_HELMET.get()));
							}
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.BOW).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS), 5);
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
								_livingEntity13.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
							if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
								_livingEntity14.getAttribute(Attributes.MAX_HEALTH).setBaseValue(300);
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth(300);
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 99999, 2));
					}
				}
			}
		}
	}
}
