package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class LavaPelletDryWaterProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		immediatesourceentity.setNoGravity(true);
		sx = -3;
		found = false;
		for (int index0 = 0; index0 < 7; index0++) {
			sy = -3;
			for (int index1 = 0; index1 < 7; index1++) {
				sz = -3;
				for (int index2 = 0; index2 < 7; index2++) {
					if ((world.getFluidState(BlockPos.containing(x + sx, y + sy, z + sz)).createLegacyBlock()).getBlock() == Blocks.WATER) {
						world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, (x + sx), (y + sy), (z + sz), 5, 0.5, 0.5, 0.5, 0);
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found == true) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, (float) 0.5, 1, false);
				}
			}
		}
		if (immediatesourceentity.getPersistentData().getDouble("ability") <= 100) {
			immediatesourceentity.getPersistentData().putDouble("ability", (immediatesourceentity.getPersistentData().getDouble("ability") + 1));
		}
		if (immediatesourceentity.getPersistentData().getDouble("ability") > 100) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
	}
}
