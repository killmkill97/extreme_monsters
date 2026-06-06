
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

public abstract class SuperLavaFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> ExtremeMonstersModFluidTypes.SUPER_LAVA_TYPE.get(), () -> ExtremeMonstersModFluids.SUPER_LAVA.get(),
			() -> ExtremeMonstersModFluids.FLOWING_SUPER_LAVA.get()).explosionResistance(100f).levelDecreasePerBlock(2).bucket(() -> ExtremeMonstersModItems.SUPER_LAVA_BUCKET.get())
			.block(() -> (LiquidBlock) ExtremeMonstersModBlocks.SUPER_LAVA.get());

	private SuperLavaFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.DRIPPING_LAVA;
	}

	public static class Source extends SuperLavaFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SuperLavaFluid {
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
