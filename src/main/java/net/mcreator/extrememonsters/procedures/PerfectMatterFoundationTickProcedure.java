package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.EntityType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class PerfectMatterFoundationTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x + 4, y, z))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_INFUSER.get() && (new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x + 4, y, z))))) == Direction.WEST) {
			if ((world.getBlockState(BlockPos.containing(x - 4, y, z))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_INFUSER.get() && (new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection((world.getBlockState(BlockPos.containing(x - 4, y, z))))) == Direction.EAST) {
				if ((world.getBlockState(BlockPos.containing(x, y, z + 4))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_INFUSER.get() && (new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y, z + 4))))) == Direction.NORTH) {
					if ((world.getBlockState(BlockPos.containing(x, y, z - 4))).getBlock() == ExtremeMonstersModBlocks.QUANTUM_INFUSER.get() && (new Object() {
						public Direction getDirection(BlockState _bs) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp)
								return _bs.getValue(_dp);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
									? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
									: Direction.NORTH;
						}
					}.getDirection((world.getBlockState(BlockPos.containing(x, y, z - 4))))) == Direction.SOUTH) {
						if ((world.getBlockState(BlockPos.containing(x + 4, y, z + 4))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
							if ((world.getBlockState(BlockPos.containing(x - 4, y, z + 4))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
								if ((world.getBlockState(BlockPos.containing(x + 4, y, z - 4))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
									if ((world.getBlockState(BlockPos.containing(x - 4, y, z - 4))).getBlock() == ExtremeMonstersModBlocks.ENERGY_STABILIZER.get()) {
										{
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("can_work") instanceof BooleanProperty _booleanProp)
												world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
										}
										if (world instanceof Level _level29 && _level29.hasNeighborSignal(BlockPos.containing(x, y, z))) {
											{
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _booleanProp)
													world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
											}
											{
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("no_button") instanceof BooleanProperty _booleanProp)
													world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
											}
										}
										if (blockstate.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _getbp33 && blockstate.getValue(_getbp33)) {
											if (new Object() {
												public double getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getDouble(tag);
													return -1;
												}
											}.getValue(world, BlockPos.containing(x + 4, y, z), "CurrentHFE") >= 200 && new Object() {
												public double getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getDouble(tag);
													return -1;
												}
											}.getValue(world, BlockPos.containing(x - 4, y, z), "CurrentHFE") >= 200 && new Object() {
												public double getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getDouble(tag);
													return -1;
												}
											}.getValue(world, BlockPos.containing(x, y, z + 4), "CurrentHFE") >= 200 && new Object() {
												public double getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getDouble(tag);
													return -1;
												}
											}.getValue(world, BlockPos.containing(x, y, z - 4), "CurrentHFE") >= 200) {
												RemoveHFEProcedure.execute(world, x + 4, y, z, 200);
												RemoveHFEProcedure.execute(world, x - 4, y, z, 200);
												RemoveHFEProcedure.execute(world, x, y, z + 4, 200);
												RemoveHFEProcedure.execute(world, x, y, z - 4, 200);
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null)
														_blockEntity.getPersistentData().putDouble("progress", (new Object() {
															public double getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getDouble(tag);
																return -1;
															}
														}.getValue(world, BlockPos.containing(x, y, z), "progress") + 1));
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.FLASH, (x + 0.5), (y + 0.5), (z + 0.5), 1, 0.6, 0.6, 0.6, 0.02);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.WAX_ON, (x + 0.5), (y + 0.5), (z + 0.5), 5, 0.6, 0.6, 0.6, 0.02);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5 + 2), (y + 0.5), (z + 0.5), 3, 1.2, 0.1, 0.1, 0);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.END_ROD, ((x + 0.5) - 2), (y + 0.5), (z + 0.5), 3, 1.2, 0.1, 0.1, 0);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 0.5), (z + 0.5 + 2), 3, 0.1, 0.1, 1.2, 0);
												if (world instanceof ServerLevel _level)
													_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 0.5), ((z + 0.5) - 2), 3, 0.1, 0.1, 1.2, 0);
												world.addParticle(ParticleTypes.END_ROD, (x + 4 + 0.5), (y + 1), (z + 4 + 0.5), (-0.05), 0, (-0.05));
												world.addParticle(ParticleTypes.END_ROD, (x - 4 + 0.5), (y + 1), (z + 4 + 0.5), 0.05, 0, (-0.05));
												world.addParticle(ParticleTypes.END_ROD, (x + 4 + 0.5), (y + 1), (z - 4 + 0.5), (-0.05), 0, 0.05);
												world.addParticle(ParticleTypes.END_ROD, (x - 4 + 0.5), (y + 1), (z - 4 + 0.5), 0.05, 0, 0.05);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:reactor_buzzing")), SoundSource.BLOCKS, (float) 0.05, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:reactor_buzzing")), SoundSource.BLOCKS, (float) 0.05, 1, false);
													}
												}
												if (new Object() {
													public double getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getDouble(tag);
														return -1;
													}
												}.getValue(world, BlockPos.containing(x, y, z), "progress") >= 2000) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putDouble("progress", 0);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (world instanceof ServerLevel _level) {
														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
														entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
														entityToSpawn.setVisualOnly(true);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof Level _level && !_level.isClientSide())
														_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.NONE);
													if (world instanceof ServerLevel _level)
														_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 5000));
													world.destroyBlock(BlockPos.containing(x, y, z), false);
													{
														BlockPos _pos = BlockPos.containing(x, y, z);
														BlockState _bs = world.getBlockState(_pos);
														if (_bs.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _booleanProp)
															world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
													}
													{
														BlockPos _pos = BlockPos.containing(x, y, z);
														BlockState _bs = world.getBlockState(_pos);
														if (_bs.getBlock().getStateDefinition().getProperty("no_button") instanceof BooleanProperty _booleanProp)
															world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
													}
													{
														BlockPos _pos = BlockPos.containing(x, y, z);
														BlockState _bs = world.getBlockState(_pos);
														if (_bs.getBlock().getStateDefinition().getProperty("can_work") instanceof BooleanProperty _booleanProp)
															world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.PERFECT_MATTER.get()));
														entityToSpawn.setPickUpDelay(10);
														entityToSpawn.setUnlimitedLifetime();
														_level.addFreshEntity(entityToSpawn);
													}
												}
											}
										}
										return;
									}
								}
							}
						}
					}
				}
			}
		}
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("can_work") instanceof BooleanProperty _booleanProp)
				world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
		}
	}
}
