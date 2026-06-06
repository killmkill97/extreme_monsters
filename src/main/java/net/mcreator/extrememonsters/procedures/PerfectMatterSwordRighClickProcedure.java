package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModMobEffects;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.entity.TrackerEntity;
import net.mcreator.extrememonsters.entity.FlyingTrackerEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class PerfectMatterSwordRighClickProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found_mob = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExtremeMonstersModItems.PERFECT_MATTER_SWORD.get()) {
			if (!(entity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()))) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 5);
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.PLAYERS, (float) 0.1, 2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("extreme_monsters:extra_function")), SoundSource.PLAYERS, (float) 0.1, 2, false);
					}
				}
				world.addParticle(ParticleTypes.FLASH, x, y, z, 0, 0, 0);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof TrackerEntity || entityiterator instanceof FlyingTrackerEntity) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.WAX_OFF, (entityiterator.getX()), (entityiterator.getY() + 0.5), (entityiterator.getZ()), 20, 0.3, 0.3, 0.3, 0.2);
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (Math.random() <= 0.1) {
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.DARK_MATTER.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							}
						}
						if (entityiterator instanceof Mob) {
							entityiterator.getPersistentData().putDouble("immobily_x", (entityiterator.getX()));
							entityiterator.getPersistentData().putDouble("immobily_y", (entityiterator.getY()));
							entityiterator.getPersistentData().putDouble("immobily_z", (entityiterator.getZ()));
							entityiterator.getPersistentData().putDouble("immobily_time", 240);
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).slash_all) {
							if (entityiterator instanceof Mob) {
								entityiterator.push((entityiterator.getX() * 0.2 - entity.getX() * 0.2), 1.4, (entityiterator.getZ() * 0.2 - entity.getZ() * 0.2));
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 20);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.EXPLOSIVE, 260, 4, false, true));
							}
						} else {
							if (entityiterator instanceof Monster) {
								entityiterator.push((entityiterator.getX() * 0.2 - entity.getX() * 0.2), 1.4, (entityiterator.getZ() * 0.2 - entity.getZ() * 0.2));
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 20);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.EXPLOSIVE, 260, 4, false, true));
							}
						}
					}
				}
			}
		}
	}
}
