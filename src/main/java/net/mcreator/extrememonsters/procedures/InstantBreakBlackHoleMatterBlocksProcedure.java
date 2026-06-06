package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InstantBreakBlackHoleMatterBlocksProcedure {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.OMEGA_WRENCH.get()) {
			if (entity.isShiftKeyDown()) {
				if (blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:blackhole_matter"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dark_matter")))
						|| blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:inferno_matter"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_matter")))
						|| blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:wither_matter")))) {
					if (blockstate.getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CONTROLLER.get() && new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "QssError") > 0) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cYou can't break it when there's an error"), true);
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						return;
					}
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()) {
			if (entity.isShiftKeyDown()) {
				if (blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:blackhole_matter")))) {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.DARK_MATTER.get()) {
			if (entity.isShiftKeyDown()) {
				if (blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dark_matter")))) {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.INFERNO_MATTER.get()) {
			if (entity.isShiftKeyDown()) {
				if (blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:inferno_matter")))) {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.DRAGON_MATTER.get()) {
			if (entity.isShiftKeyDown()) {
				if (blockstate.getBlock() == ExtremeMonstersModBlocks.DRAGON_QSS_CONTROLLER.get() && new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "QssError") > 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7cYou can't break it when there's an error"), true);
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
					return;
				}
				if (blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:dragon_matter")))) {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.WITHER_MATTER.get()) {
			if (entity.isShiftKeyDown()) {
				if (blockstate.is(BlockTags.create(ResourceLocation.parse("extreme_monsters:wither_matter")))) {
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
