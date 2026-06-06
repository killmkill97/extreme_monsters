
package net.mcreator.extrememonsters.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class InfernoMiningCasingBlock extends Block {
	public InfernoMiningCasingBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(300f, 9999f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
