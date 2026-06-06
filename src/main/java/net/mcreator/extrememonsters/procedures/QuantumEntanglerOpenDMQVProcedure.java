package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QuantumEntanglerOpenDMQVProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack hand_item = ItemStack.EMPTY;
		hand_item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		if (hand_item.getItem() == ExtremeMonstersModItems.QUANTUM_ENTANGLER.get()) {
			if (hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("entangle")) {
				if ((hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("use")).equals("open")) {
					if (world instanceof ServerLevel _origLevel) {
						LevelAccessor _worldorig = world;
						world = _origLevel.getServer().getLevel(Level.OVERWORLD);
						if (world != null) {
							if ((world.getBlockState(BlockPos.containing(hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sx"),
									hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sy"), hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sz"))))
									.getBlock() == ExtremeMonstersModBlocks.DARK_MATTER_QUANTUM_VAULT.get()) {
								if (entity instanceof Player _player) {
									BlockPos _bp = BlockPos.containing(hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sx"),
											hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sy"), hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sz"));
									_player.level().getBlockState(_bp).useWithoutItem(_player.level(), _player, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Invalid block."), true);
							}
						}
						world = _worldorig;
					}
				} else if ((hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("use")).equals("anchor")) {
					if ((world.getBlockState(BlockPos.containing(hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sx"),
							hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sy"), hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sz"))))
							.getBlock() == ExtremeMonstersModBlocks.QUANTUM_ANCHOR.get()) {
						if (world instanceof ServerLevel _origLevel) {
							LevelAccessor _worldorig = world;
							world = _origLevel.getServer().getLevel(Level.OVERWORLD);
							if (world != null) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												("execute in " + hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("dimension") + " run tp "
														+ (hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sx") + 0.5) + " "
														+ (hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sy") + 1) + " "
														+ (hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sz") + 0.5)));
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null,
												BlockPos.containing(hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sx"),
														hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sy"), hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sz")),
												BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.travel")), SoundSource.BLOCKS, 1, 1);
									} else {
										_level.playLocalSound((hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sx")),
												(hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sy")), (hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sz")),
												BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.travel")), SoundSource.BLOCKS, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sx") + 0.5),
											(hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sy") + 1), (hand_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("sz") + 0.5),
											300, 0.5, 1, 0.5, 0);
							}
							world = _worldorig;
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Invalid block."), true);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Don't entangle yet."), true);
			}
		}
	}
}
