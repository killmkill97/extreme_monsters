package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperWitherSpawnWitherProcedure {
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
		double rx = 0;
		double rz = 0;
		if (entity instanceof WitherBoss) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (entity.getPersistentData().getDouble("hyper_wither_summon") <= 0) {
						entity.getPersistentData().putDouble("hyper_wither_summon", 700);
					}
					if (entity.getPersistentData().getDouble("hyper_wither_summon") >= 0) {
						entity.getPersistentData().putDouble("hyper_wither_summon", (entity.getPersistentData().getDouble("hyper_wither_summon") - 1));
					}
					if (entity.getPersistentData().getDouble("hyper_wither_summon") <= 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						for (int index0 = 0; index0 < 5; index0++) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLASH, x, y, z, 2, 0.5, 1, 0.5, 0.2);
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.WITHER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
				}
			}
		}
	}
}
