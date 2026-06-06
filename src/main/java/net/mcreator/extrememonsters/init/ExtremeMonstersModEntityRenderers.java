
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.extrememonsters.client.renderer.WeakTrackerRenderer;
import net.mcreator.extrememonsters.client.renderer.WeakFlyingTrackerRenderer;
import net.mcreator.extrememonsters.client.renderer.TrackerRenderer;
import net.mcreator.extrememonsters.client.renderer.TamableTrackerRenderer;
import net.mcreator.extrememonsters.client.renderer.SuperTrackerRenderer;
import net.mcreator.extrememonsters.client.renderer.HyperTrackerRenderer;
import net.mcreator.extrememonsters.client.renderer.FlyingTrackerRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExtremeMonstersModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ExtremeMonstersModEntities.TRACKER.get(), TrackerRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.FLYING_TRACKER.get(), FlyingTrackerRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.HOMING_ARROW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.NOMAL_ARROW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.CREEPER_EGG.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.HOMING_ARROW_PLAYER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.LAVA_PELLET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.WATER_PELLET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.NOMAL_ARROW_PLAYER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.BLACK_HOLE_BOMB_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.DARK_MATTER_BOMB_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.INFERNO_MATTER_BOMB_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.NOMAL_SMALL_FIRE_BALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.BLACK_HOLE_MATTER_EXP_BOTTLE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.DARK_MATTER_EXP_BOTTLE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.INFERNO_MATTER_EXP_BOTTLE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.END_METEOR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.WITHERED_DARK_MATTER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.SUPER_TRACKER.get(), SuperTrackerRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.GRIEFING_PLAYER_WITHERED_DARK_MATTER_MAIN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.GRIEFING_PLAYER_WITHERED_DARK_MATTER_SUB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.PLYER_WITHERED_DARK_MATTER_MAIN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.PLAYER_WITHERED_DARK_MATTER_SUB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.PERFECT_DARK_MATTER_SUB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.PERFECT_DARK_MATTER_MAIN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.HYPER_TRACKER.get(), HyperTrackerRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.TRACKER_METEOR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.TAMABLE_TRACKER.get(), TamableTrackerRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.TAMABLE_TRACKER_METEOR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.HYPER_WITHER_WITHERD_DARK_MATTER_CLUMP.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.WEAK_TRACKER.get(), WeakTrackerRenderer::new);
		event.registerEntityRenderer(ExtremeMonstersModEntities.WEAK_FLYING_TRACKER.get(), WeakFlyingTrackerRenderer::new);
	}
}
