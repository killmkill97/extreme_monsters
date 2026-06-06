package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModMobEffects;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class HyperZombieunResurrectProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Zombie) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Zombie && (entityiterator instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS)
							? _livingEntity2.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue()
							: 0) == 1) {
						if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(ExtremeMonstersModMobEffects.UNRESURRECT))
								&& (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS)
										? _livingEntity4.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue()
										: 0) == 0) {
							if (event instanceof ICancellableEvent _cancellable) {
								_cancellable.setCanceled(true);
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(ExtremeMonstersModMobEffects.UNRESURRECT, 300, 1));
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth(20);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, (entity.getX()), (entity.getY() + 0.5), (entity.getZ()), 500, 0.1, 0.1, 0.1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.HOSTILE, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.HOSTILE, (float) 0.5, 1, false);
								}
							}
						}
					}
				}
			}
		}
	}
}
