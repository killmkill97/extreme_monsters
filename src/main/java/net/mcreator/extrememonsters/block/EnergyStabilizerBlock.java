
package net.mcreator.extrememonsters.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class EnergyStabilizerBlock extends Block {
	public EnergyStabilizerBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(500f, 999999f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
