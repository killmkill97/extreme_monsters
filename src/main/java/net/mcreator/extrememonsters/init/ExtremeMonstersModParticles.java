
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.extrememonsters.client.particle.SupernovarEffectParticle;
import net.mcreator.extrememonsters.client.particle.SmallMVSStarParticle;
import net.mcreator.extrememonsters.client.particle.LargeMVSStarParticle;
import net.mcreator.extrememonsters.client.particle.GenericMVSStarParticle;
import net.mcreator.extrememonsters.client.particle.BlueWhiteMVSStarParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExtremeMonstersModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ExtremeMonstersModParticleTypes.GENERIC_MVS_STAR.get(), GenericMVSStarParticle::provider);
		event.registerSpriteSet(ExtremeMonstersModParticleTypes.LARGE_MVS_STAR.get(), LargeMVSStarParticle::provider);
		event.registerSpriteSet(ExtremeMonstersModParticleTypes.SMALL_MVS_STAR.get(), SmallMVSStarParticle::provider);
		event.registerSpriteSet(ExtremeMonstersModParticleTypes.BLUE_WHITE_MVS_STAR.get(), BlueWhiteMVSStarParticle::provider);
		event.registerSpriteSet(ExtremeMonstersModParticleTypes.SUPERNOVAR_EFFECT.get(), SupernovarEffectParticle::provider);
	}
}
