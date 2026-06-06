package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NoExplodeDamagehyperMobsProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity) {
		execute(null, damagesource, entity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity0.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
			if (entity instanceof EnderDragon) {
				if (damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.FALL) || damagesource.is(DamageTypes.PLAYER_EXPLOSION)) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				} else if (damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.ON_FIRE) || damagesource.is(DamageTypes.LAVA)) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
					entity.clearFire();
				}
			} else {
				if (damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.FALL) || damagesource.is(DamageTypes.ARROW) || damagesource.is(DamageTypes.MOB_PROJECTILE) || damagesource.is(DamageTypes.PLAYER_EXPLOSION)) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				} else if (damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.ON_FIRE) || damagesource.is(DamageTypes.LAVA)) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
					entity.clearFire();
				}
			}
		}
	}
}
