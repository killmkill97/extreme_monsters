package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class HyperWitherSkeletonWeaponChangeProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean on_hand_sword = false;
		boolean success = false;
		if (entity instanceof WitherSkeleton) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, x, y, z, 5, 0.5, 2, 0.5, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 8, 3, 0.2, 3, 0);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player) || !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 1, true, false));
						}
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1, false, false));
				if (entity.getPersistentData().getDouble("change_mob_mode_timer") <= 0) {
					entity.getPersistentData().putDouble("change_mob_mode_timer", 200);
				}
				if (entity.getPersistentData().getDouble("change_mob_mode_timer") >= 0) {
					entity.getPersistentData().putDouble("change_mob_mode_timer", (entity.getPersistentData().getDouble("change_mob_mode_timer") - 1));
				}
				if (entity.getPersistentData().getDouble("change_mob_mode_timer") <= 0) {
					if ((entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(ExtremeMonstersModAttributes.ON_HAND_SWORD)
							? _livingEntity18.getAttribute(ExtremeMonstersModAttributes.ON_HAND_SWORD).getBaseValue()
							: 0) == 1) {
						if (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(ExtremeMonstersModAttributes.ON_HAND_SWORD))
							_livingEntity19.getAttribute(ExtremeMonstersModAttributes.ON_HAND_SWORD).setBaseValue(0);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.BOW).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else {
						if (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(ExtremeMonstersModAttributes.ON_HAND_SWORD))
							_livingEntity21.getAttribute(ExtremeMonstersModAttributes.ON_HAND_SWORD).setBaseValue(1);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.NETHERITE_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
			}
		}
	}
}
