
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.extrememonsters.fluid.types.SuperLavaFluidType;
import net.mcreator.extrememonsters.fluid.types.MolecularSolventFluidType;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

public class ExtremeMonstersModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, ExtremeMonstersMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> SUPER_LAVA_TYPE = REGISTRY.register("super_lava", () -> new SuperLavaFluidType());
	public static final DeferredHolder<FluidType, FluidType> MOLECULAR_SOLVENT_TYPE = REGISTRY.register("molecular_solvent", () -> new MolecularSolventFluidType());
}
