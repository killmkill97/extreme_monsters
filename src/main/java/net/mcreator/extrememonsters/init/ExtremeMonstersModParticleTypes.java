
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.extrememonsters.ExtremeMonstersMod;

public class ExtremeMonstersModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, ExtremeMonstersMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GENERIC_MVS_STAR = REGISTRY.register("generic_mvs_star", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LARGE_MVS_STAR = REGISTRY.register("large_mvs_star", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SMALL_MVS_STAR = REGISTRY.register("small_mvs_star", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLUE_WHITE_MVS_STAR = REGISTRY.register("blue_white_mvs_star", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SUPERNOVAR_EFFECT = REGISTRY.register("supernovar_effect", () -> new SimpleParticleType(true));
}
