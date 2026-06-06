package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OmegaWrenchInstantBreakeProcedure {
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
		if (entity.isShiftKeyDown()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.OMEGA_WRENCH.get()) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.OMEGA_D_CORE_STABILIZER.get()) {
					if ((blockstate.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _getbp6 && blockstate.getValue(_getbp6)) == false) {
						{
							BlockPos _pos = BlockPos.containing(x, y, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
							world.destroyBlock(_pos, false);
						}
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					}
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.OMEGA_D_CORE.get()) {
					if ((blockstate.getBlock().getStateDefinition().getProperty("real_work") instanceof BooleanProperty _getbp15 && blockstate.getValue(_getbp15)) == false) {
						if ((blockstate.getBlock().getStateDefinition().getProperty("explosion_imminent") instanceof BooleanProperty _getbp17 && blockstate.getValue(_getbp17)) == false) {
							if (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "odr_temperature") == 0) {
								{
									BlockPos _pos = BlockPos.containing(x, y, z);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
									world.destroyBlock(_pos, false);
								}
								{
									BlockPos _pos = BlockPos.containing(x + 4, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _booleanProp)
										world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
								}
								{
									BlockPos _pos = BlockPos.containing(x - 4, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _booleanProp)
										world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
								}
								{
									BlockPos _pos = BlockPos.containing(x, y, z + 4);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _booleanProp)
										world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
								}
								{
									BlockPos _pos = BlockPos.containing(x, y, z - 4);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("work") instanceof BooleanProperty _booleanProp)
										world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x + 4, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x - 4, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z + 4);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z - 4);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
							}
						}
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.PERFECT_MATTER_BLOCK.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.INFINITY_MATRIX.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.INFINITY_SIMULATION_CHAMBER.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.INFINITY_TRACKER_DEFENDER.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.DYSON_RING_CONTROLLER.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.ULTIMATE_BLOCK.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.MOLECULAR_ASSEMBLER.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.MOLECULAR_DISSOLVER.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.MOLECULAR_MATTER_RESYNTHESIZER.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.MOLECULAR_COMPRESSION_STATION.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ExtremeMonstersModBlocks.MICROVERSE_STABILIZER.get()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				}
			}
		}
	}
}
