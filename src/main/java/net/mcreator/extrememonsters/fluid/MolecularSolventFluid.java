
package net.mcreator.extrememonsters.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModFluids;
import net.mcreator.extrememonsters.init.ExtremeMonstersModFluidTypes;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public abstract class MolecularSolventFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> ExtremeMonstersModFluidTypes.MOLECULAR_SOLVENT_TYPE.get(), () -> ExtremeMonstersModFluids.MOLECULAR_SOLVENT.get(),
			() -> ExtremeMonstersModFluids.FLOWING_MOLECULAR_SOLVENT.get()).explosionResistance(9999f).bucket(() -> ExtremeMonstersModItems.MOLECULAR_SOLVENT_BUCKET.get()).block(() -> (LiquidBlock) ExtremeMonstersModBlocks.MOLECULAR_SOLVENT.get());

	private MolecularSolventFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.WHITE_ASH;
	}

	public static class Source extends MolecularSolventFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MolecularSolventFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
