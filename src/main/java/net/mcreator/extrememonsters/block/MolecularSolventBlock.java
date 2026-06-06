
package net.mcreator.extrememonsters.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.extrememonsters.init.ExtremeMonstersModFluids;

public class MolecularSolventBlock extends LiquidBlock {
	public MolecularSolventBlock() {
		super(ExtremeMonstersModFluids.MOLECULAR_SOLVENT.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(9999f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noCollission().noLootTable().liquid()
				.pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}
