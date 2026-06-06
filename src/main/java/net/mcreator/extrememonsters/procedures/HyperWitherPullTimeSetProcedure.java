package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperWitherPullTimeSetProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		boolean success = false;
		if (entity instanceof WitherBoss) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (entity.getPersistentData().getDouble("hyper_wither_pull_cool") <= 0) {
						entity.getPersistentData().putDouble("hyper_wither_pull_cool", 500);
					}
					if (entity.getPersistentData().getDouble("hyper_wither_pull_cool") > 0) {
						entity.getPersistentData().putDouble("hyper_wither_pull_cool", (entity.getPersistentData().getDouble("hyper_wither_pull_cool") - 1));
					}
					if (entity.getPersistentData().getDouble("hyper_wither_pull_cool") <= 0) {
						entity.getPersistentData().putDouble("hyper_wither_pull", 100);
					}
				}
			}
		}
	}
}
