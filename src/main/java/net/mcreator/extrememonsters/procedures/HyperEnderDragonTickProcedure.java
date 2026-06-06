package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class HyperEnderDragonTickProcedure {
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
		double hypermobs_number = 0;
		double random = 0;
		if (entity instanceof EnderDragon) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 20, 5, 4, 5, 0.1);
				if (entity.getPersistentData().getDouble("ability") <= 0) {
					entity.getPersistentData().putDouble("ability", 600);
				}
				if (entity.getPersistentData().getDouble("ability") >= 0) {
					entity.getPersistentData().putDouble("ability", (entity.getPersistentData().getDouble("ability") - 1));
				}
				if (entity.getPersistentData().getDouble("ability") <= 0) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(500 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof EnderMan)) {
								if ((entityiterator instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS)
										? _livingEntity10.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue()
										: 0) == 1) {
									hypermobs_number = hypermobs_number + 1;
								}
							}
						}
					}
					if (hypermobs_number <= 10) {
						random = Math.random();
						if (random < 0.25) {
							for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 5, 10); index0++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						} else if (random >= 0.25 && random < 0.5) {
							for (int index1 = 0; index1 < (int) Mth.nextDouble(RandomSource.create(), 5, 10); index1++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						} else if (random >= 5 && random < 0.75) {
							for (int index2 = 0; index2 < (int) Mth.nextDouble(RandomSource.create(), 5, 10); index2++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.CREEPER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						} else if (random >= 0.75) {
							for (int index3 = 0; index3 < (int) Mth.nextDouble(RandomSource.create(), 5, 10); index3++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z, 50, 3, 3, 3, 0.2);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
