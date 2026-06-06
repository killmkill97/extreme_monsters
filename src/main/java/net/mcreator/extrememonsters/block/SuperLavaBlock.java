
package net.mcreator.extrememonsters.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.procedures.SuperLavaDamageProcedure;
import net.mcreator.extrememonsters.init.ExtremeMonstersModFluids;

public class SuperLavaBlock extends LiquidBlock {
	public SuperLavaBlock() {
		super(ExtremeMonstersModFluids.SUPER_LAVA.get(),
				BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(100f).lightLevel(s -> 15).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		SuperLavaDamageProcedure.execute(world, entity);
	}
}
