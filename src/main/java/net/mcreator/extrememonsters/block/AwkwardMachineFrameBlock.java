
package net.mcreator.extrememonsters.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class AwkwardMachineFrameBlock extends Block {
	public AwkwardMachineFrameBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1500f, 999f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
