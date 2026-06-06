
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.extrememonsters.fluid.SuperLavaFluid;
import net.mcreator.extrememonsters.fluid.MolecularSolventFluid;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

public class ExtremeMonstersModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, ExtremeMonstersMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> SUPER_LAVA = REGISTRY.register("super_lava", () -> new SuperLavaFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_SUPER_LAVA = REGISTRY.register("flowing_super_lava", () -> new SuperLavaFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> MOLECULAR_SOLVENT = REGISTRY.register("molecular_solvent", () -> new MolecularSolventFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MOLECULAR_SOLVENT = REGISTRY.register("flowing_molecular_solvent", () -> new MolecularSolventFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(SUPER_LAVA.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_SUPER_LAVA.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(MOLECULAR_SOLVENT.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MOLECULAR_SOLVENT.get(), RenderType.translucent());
		}
	}
}
