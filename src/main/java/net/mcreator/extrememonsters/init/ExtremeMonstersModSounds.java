
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.extrememonsters.ExtremeMonstersMod;

public class ExtremeMonstersModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ExtremeMonstersMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> EXTRA_FUNCTION = REGISTRY.register("extra_function", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("extreme_monsters", "extra_function")));
	public static final DeferredHolder<SoundEvent, SoundEvent> REACTOR_BUZZING = REGISTRY.register("reactor_buzzing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("extreme_monsters", "reactor_buzzing")));
}
