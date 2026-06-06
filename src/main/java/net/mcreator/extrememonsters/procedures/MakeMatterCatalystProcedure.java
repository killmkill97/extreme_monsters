package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MakeMatterCatalystProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if (entity.isShiftKeyDown() == false) {
				if (((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.BEDROCK || (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DUPLICATED_BEDROCK.get())
						&& blockstate.getBlock() == ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.MATTER_CATALYST_FOUNDATION.get()) {
						world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y - 1, z), ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_SHARD.get()));
							entityToSpawn.setPickUpDelay(10);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, (x + 0.5), ((y + 0.5) - 2), (z + 0.5), 150, 0.3, 0.3, 0.3, 0.1);
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if (entity.isShiftKeyDown() == false) {
				if (((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.BEDROCK || (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DUPLICATED_BEDROCK.get())
						&& blockstate.getBlock() == ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.MATTER_CATALYST_FOUNDATION_1X.get()) {
						world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y - 1, z), ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get().defaultBlockState(), 3);
						for (int index0 = 0; index0 < 9; index0++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_SHARD.get()));
								entityToSpawn.setPickUpDelay(10);
								entityToSpawn.setUnlimitedLifetime();
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, (x + 0.5), ((y + 0.5) - 2), (z + 0.5), 150, 0.3, 0.3, 0.3, 0.1);
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if (entity.isShiftKeyDown() == false) {
				if (((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.BEDROCK || (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DUPLICATED_BEDROCK.get())
						&& blockstate.getBlock() == ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.MATTER_CATALYST_FOUNDATION_2X.get()) {
						world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y - 1, z), ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get().defaultBlockState(), 3);
						for (int index1 = 0; index1 < 81; index1++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_SHARD.get()));
								entityToSpawn.setPickUpDelay(10);
								entityToSpawn.setUnlimitedLifetime();
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, (x + 0.5), ((y + 0.5) - 2), (z + 0.5), 150, 0.3, 0.3, 0.3, 0.1);
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if (entity.isShiftKeyDown() == false) {
				if (((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.BEDROCK || (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == ExtremeMonstersModBlocks.DUPLICATED_BEDROCK.get())
						&& blockstate.getBlock() == ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ExtremeMonstersModBlocks.MATTER_CATALYST_FOUNDATION_3X.get()) {
						world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y - 1, z), ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get().defaultBlockState(), 3);
						for (int index2 = 0; index2 < 729; index2++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(ExtremeMonstersModItems.MATTER_CATALYST_SHARD.get()));
								entityToSpawn.setPickUpDelay(10);
								entityToSpawn.setUnlimitedLifetime();
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, (x + 0.5), ((y + 0.5) - 2), (z + 0.5), 150, 0.3, 0.3, 0.3, 0.1);
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					}
				}
			}
		}
	}
}
