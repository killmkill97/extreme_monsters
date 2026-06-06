package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShieldCapacityWorkProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		execute(null, world, x, y, z, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double math_max = 0;
		double math_min = 0;
		double math_max_compute_1 = 0;
		double math_max_compute_2 = 0;
		double final_number = 0;
		double protection_damage_compute = 0;
		double protection_compute_loop = 0;
		double resistance_compute = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ExtremeMonstersModItems.SUPER_DAMAGE_PROTECTOR.get())) : false) {
			if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity > 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				math_max_compute_1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 5;
				math_max_compute_2 = (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0)
						- amount / (2 + (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS) ? _livingEntity4.getAttribute(Attributes.ARMOR_TOUGHNESS).getBaseValue() : 0) / 4);
				if (math_max_compute_1 > math_max_compute_2) {
					math_max = math_max_compute_1;
				} else {
					math_max = math_max_compute_2;
				}
				if (20 > math_max) {
					math_min = math_max;
				} else {
					math_min = 20;
				}
				final_number = amount * (1 - math_min / 25);
				protection_damage_compute = 0;
				for (int index0 = 0; index0 < 4; index0++) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(new Object() {
						public static EquipmentSlot armorSlotByIndex(int _slotindex) {
							for (EquipmentSlot _slot : EquipmentSlot.values()) {
								if (_slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && _slot.getIndex() == _slotindex) {
									return _slot;
								}
							}
							throw new IllegalArgumentException("Invalid slot index: " + _slotindex);
						}
					}.armorSlotByIndex((int) protection_compute_loop)) : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION)) != 0) {
						protection_damage_compute = protection_damage_compute + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(new Object() {
							public static EquipmentSlot armorSlotByIndex(int _slotindex) {
								for (EquipmentSlot _slot : EquipmentSlot.values()) {
									if (_slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && _slot.getIndex() == _slotindex) {
										return _slot;
									}
								}
								throw new IllegalArgumentException("Invalid slot index: " + _slotindex);
							}
						}.armorSlotByIndex((int) protection_compute_loop)) : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION)) * 3;
					}
					protection_compute_loop = protection_compute_loop + 1;
				}
				if (protection_damage_compute > 80) {
					protection_damage_compute = 80;
				}
				if (protection_damage_compute > 0) {
					final_number = final_number * protection_damage_compute * 0.01;
				}
				if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
					resistance_compute = 1 - (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0) * 0.2;
					if (resistance_compute <= 0) {
						resistance_compute = 0;
					}
					final_number = final_number * resistance_compute;
				}
				{
					ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
					_vars.shield_capacity = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity - final_number;
					_vars.syncPlayerVariables(entity);
				}
				entity.getPersistentData().putDouble("shield_damage_timer", 40);
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
		}
	}
}
