package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class DropHyperItemsProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		execute(null, world, x, y, z, damagesource, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		boolean drop_sub_items = false;
		if ((!damagesource.is(DamageTypes.MOB_PROJECTILE) || !damagesource.is(DamageTypes.MOB_ATTACK) || !damagesource.is(DamageTypes.MOB_ATTACK_NO_AGGRO))
				&& (ExtremeMonstersModVariables.MapVariables.get(world).Extreme || ExtremeMonstersConfigurationConfiguration.CAN_GET_EM_LOOT.get())
				&& (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS)
						? _livingEntity4.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue()
						: 0) == 1) {
			if (entity instanceof Skeleton) {
				for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 1, 5); index0++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_BONE.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof Zombie && !(entity instanceof ZombifiedPiglin)) {
				for (int index1 = 0; index1 < (int) Mth.nextDouble(RandomSource.create(), 1, 5); index1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_ROTTEN_FLESH.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof Creeper) {
				for (int index2 = 0; index2 < (int) Mth.nextDouble(RandomSource.create(), 1, 5); index2++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_GUNPOWDER.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof Spider) {
				for (int index3 = 0; index3 < (int) Mth.nextDouble(RandomSource.create(), 1, 5); index3++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_SPIDER_EYE.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof ZombifiedPiglin) {
				for (int index4 = 0; index4 < (int) Mth.nextDouble(RandomSource.create(), 2, 10); index4++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_GOLD_NUGGET.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof MagmaCube) {
				for (int index5 = 0; index5 < 5; index5++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_MAGMA_CREAM.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
				for (int index6 = 0; index6 < (int) Mth.nextDouble(RandomSource.create(), 10, 20); index6++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof WitherSkeleton) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.WITHER_SKELETON_SKULL));
					entityToSpawn.setPickUpDelay(10);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
				for (int index7 = 0; index7 < (int) Mth.nextDouble(RandomSource.create(), 1, 5); index7++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_WITHERED_BONE.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof Blaze) {
				for (int index8 = 0; index8 < (int) Mth.nextDouble(RandomSource.create(), 1, 10); index8++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BLAZE_ROD));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
				for (int index9 = 0; index9 < (int) Mth.nextDouble(RandomSource.create(), 1, 5); index9++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_BLAZE_ROD.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof EnderMan) {
				for (int index10 = 0; index10 < (int) Mth.nextDouble(RandomSource.create(), 1, 10); index10++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ENDER_PEARL));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
				for (int index11 = 0; index11 < (int) Mth.nextDouble(RandomSource.create(), 1, 5); index11++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.HYPER_ENDER_PEARL.get()));
						entityToSpawn.setPickUpDelay(10);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (entity instanceof EnderDragon) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.HYPER_DRAGON_SKIN.get()).copy();
								_setstack.setCount(5);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()).copy();
								_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 64, 128));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.DARK_MATTER.get()).copy();
								_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 5, 10));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
				}
			}
			if (entity instanceof WitherBoss) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.HYPER_NETHER_STAR.get()).copy();
								_setstack.setCount(5);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.NETHER_STAR).copy();
								_setstack.setCount(25);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()).copy();
								_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 128, 192));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.DARK_MATTER.get()).copy();
								_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 12, 15));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ExtremeMonstersModItems.INFERNO_MATTER.get()).copy();
								_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 5, 10));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
				}
			}
			for (int index12 = 0; index12 < (int) Mth.nextDouble(RandomSource.create(), 10, 20); index12++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ExtremeMonstersModItems.BLACK_HOLE_MATTER.get()));
					entityToSpawn.setPickUpDelay(10);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
