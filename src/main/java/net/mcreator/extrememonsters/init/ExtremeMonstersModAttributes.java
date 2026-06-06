
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.stream.Collectors;
import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ExtremeMonstersModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, ExtremeMonstersMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> HYPER_MOBS = REGISTRY.register("hyper_mobs", () -> new RangedAttribute("attribute.extreme_monsters.hyper_mobs", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> ON_GROUND_DETECTED = REGISTRY.register("on_ground_detected", () -> new RangedAttribute("attribute.extreme_monsters.on_ground_detected", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> PROTECT_ATTACK = REGISTRY.register("protect_attack", () -> new RangedAttribute("attribute.extreme_monsters.protect_attack", 0, 0, 100).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> ON_HAND_SWORD = REGISTRY.register("on_hand_sword", () -> new RangedAttribute("attribute.extreme_monsters.on_hand_sword", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> INVINCIBILITY = REGISTRY.register("invincibility", () -> new RangedAttribute("attribute.extreme_monsters.invincibility", 0, 0, 1).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, HYPER_MOBS));
		List.of(EntityType.MAGMA_CUBE).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList()).forEach(entity -> event.add(entity, ON_GROUND_DETECTED));
		List.of(EntityType.MAGMA_CUBE).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList()).forEach(entity -> event.add(entity, PROTECT_ATTACK));
		List.of(EntityType.WITHER_SKELETON).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList()).forEach(entity -> event.add(entity, ON_HAND_SWORD));
		List.of(EntityType.MAGMA_CUBE).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList()).forEach(entity -> event.add(entity, INVINCIBILITY));
	}
}
