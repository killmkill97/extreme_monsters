
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.extrememonsters.entity.WitheredDarkMatterEntity;
import net.mcreator.extrememonsters.entity.WeakTrackerEntity;
import net.mcreator.extrememonsters.entity.WeakFlyingTrackerEntity;
import net.mcreator.extrememonsters.entity.WaterPelletEntity;
import net.mcreator.extrememonsters.entity.TrackerMeteorEntity;
import net.mcreator.extrememonsters.entity.TrackerEntity;
import net.mcreator.extrememonsters.entity.TamableTrackerMeteorEntity;
import net.mcreator.extrememonsters.entity.TamableTrackerEntity;
import net.mcreator.extrememonsters.entity.SuperTrackerEntity;
import net.mcreator.extrememonsters.entity.PlyerWitheredDarkMatterMainEntity;
import net.mcreator.extrememonsters.entity.PlayerWitheredDarkMatterSubEntity;
import net.mcreator.extrememonsters.entity.PerfectDarkMatterSubEntity;
import net.mcreator.extrememonsters.entity.PerfectDarkMatterMainEntity;
import net.mcreator.extrememonsters.entity.NomalSmallFireBallEntity;
import net.mcreator.extrememonsters.entity.NomalArrowPlayerEntity;
import net.mcreator.extrememonsters.entity.NomalArrowEntity;
import net.mcreator.extrememonsters.entity.LavaPelletEntity;
import net.mcreator.extrememonsters.entity.InfernoMatterExpBottleProjectileEntity;
import net.mcreator.extrememonsters.entity.InfernoMatterBombProjectileEntity;
import net.mcreator.extrememonsters.entity.HyperWitherWitherdDarkMatterClumpEntity;
import net.mcreator.extrememonsters.entity.HyperTrackerEntity;
import net.mcreator.extrememonsters.entity.HomingArrowPlayerEntity;
import net.mcreator.extrememonsters.entity.HomingArrowEntity;
import net.mcreator.extrememonsters.entity.GriefingPlayerWitheredDarkMatterSubEntity;
import net.mcreator.extrememonsters.entity.GriefingPlayerWitheredDarkMatterMainEntity;
import net.mcreator.extrememonsters.entity.FlyingTrackerEntity;
import net.mcreator.extrememonsters.entity.EndMeteorEntity;
import net.mcreator.extrememonsters.entity.DarkMatterExpBottleProjectileEntity;
import net.mcreator.extrememonsters.entity.DarkMatterBombProjectileEntity;
import net.mcreator.extrememonsters.entity.CreeperEggEntity;
import net.mcreator.extrememonsters.entity.BlackHoleMatterExpBottleProjectileEntity;
import net.mcreator.extrememonsters.entity.BlackHoleBombProjectileEntity;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ExtremeMonstersModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, ExtremeMonstersMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<TrackerEntity>> TRACKER = register("tracker",
			EntityType.Builder.<TrackerEntity>of(TrackerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlyingTrackerEntity>> FLYING_TRACKER = register("flying_tracker",
			EntityType.Builder.<FlyingTrackerEntity>of(FlyingTrackerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.9f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<HomingArrowEntity>> HOMING_ARROW = register("homing_arrow",
			EntityType.Builder.<HomingArrowEntity>of(HomingArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<NomalArrowEntity>> NOMAL_ARROW = register("nomal_arrow",
			EntityType.Builder.<NomalArrowEntity>of(NomalArrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CreeperEggEntity>> CREEPER_EGG = register("creeper_egg",
			EntityType.Builder.<CreeperEggEntity>of(CreeperEggEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<HomingArrowPlayerEntity>> HOMING_ARROW_PLAYER = register("homing_arrow_player",
			EntityType.Builder.<HomingArrowPlayerEntity>of(HomingArrowPlayerEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LavaPelletEntity>> LAVA_PELLET = register("lava_pellet",
			EntityType.Builder.<LavaPelletEntity>of(LavaPelletEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WaterPelletEntity>> WATER_PELLET = register("water_pellet",
			EntityType.Builder.<WaterPelletEntity>of(WaterPelletEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<NomalArrowPlayerEntity>> NOMAL_ARROW_PLAYER = register("nomal_arrow_player",
			EntityType.Builder.<NomalArrowPlayerEntity>of(NomalArrowPlayerEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlackHoleBombProjectileEntity>> BLACK_HOLE_BOMB_PROJECTILE = register("black_hole_bomb_projectile",
			EntityType.Builder.<BlackHoleBombProjectileEntity>of(BlackHoleBombProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DarkMatterBombProjectileEntity>> DARK_MATTER_BOMB_PROJECTILE = register("dark_matter_bomb_projectile",
			EntityType.Builder.<DarkMatterBombProjectileEntity>of(DarkMatterBombProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<InfernoMatterBombProjectileEntity>> INFERNO_MATTER_BOMB_PROJECTILE = register("inferno_matter_bomb_projectile",
			EntityType.Builder.<InfernoMatterBombProjectileEntity>of(InfernoMatterBombProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<NomalSmallFireBallEntity>> NOMAL_SMALL_FIRE_BALL = register("nomal_small_fire_ball",
			EntityType.Builder.<NomalSmallFireBallEntity>of(NomalSmallFireBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlackHoleMatterExpBottleProjectileEntity>> BLACK_HOLE_MATTER_EXP_BOTTLE_PROJECTILE = register("black_hole_matter_exp_bottle_projectile",
			EntityType.Builder.<BlackHoleMatterExpBottleProjectileEntity>of(BlackHoleMatterExpBottleProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DarkMatterExpBottleProjectileEntity>> DARK_MATTER_EXP_BOTTLE_PROJECTILE = register("dark_matter_exp_bottle_projectile",
			EntityType.Builder.<DarkMatterExpBottleProjectileEntity>of(DarkMatterExpBottleProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<InfernoMatterExpBottleProjectileEntity>> INFERNO_MATTER_EXP_BOTTLE_PROJECTILE = register("inferno_matter_exp_bottle_projectile",
			EntityType.Builder.<InfernoMatterExpBottleProjectileEntity>of(InfernoMatterExpBottleProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<EndMeteorEntity>> END_METEOR = register("end_meteor",
			EntityType.Builder.<EndMeteorEntity>of(EndMeteorEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WitheredDarkMatterEntity>> WITHERED_DARK_MATTER = register("withered_dark_matter",
			EntityType.Builder.<WitheredDarkMatterEntity>of(WitheredDarkMatterEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SuperTrackerEntity>> SUPER_TRACKER = register("super_tracker",
			EntityType.Builder.<SuperTrackerEntity>of(SuperTrackerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1.4f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<GriefingPlayerWitheredDarkMatterMainEntity>> GRIEFING_PLAYER_WITHERED_DARK_MATTER_MAIN = register("griefing_player_withered_dark_matter_main",
			EntityType.Builder.<GriefingPlayerWitheredDarkMatterMainEntity>of(GriefingPlayerWitheredDarkMatterMainEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GriefingPlayerWitheredDarkMatterSubEntity>> GRIEFING_PLAYER_WITHERED_DARK_MATTER_SUB = register("griefing_player_withered_dark_matter_sub",
			EntityType.Builder.<GriefingPlayerWitheredDarkMatterSubEntity>of(GriefingPlayerWitheredDarkMatterSubEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PlyerWitheredDarkMatterMainEntity>> PLYER_WITHERED_DARK_MATTER_MAIN = register("plyer_withered_dark_matter_main",
			EntityType.Builder.<PlyerWitheredDarkMatterMainEntity>of(PlyerWitheredDarkMatterMainEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PlayerWitheredDarkMatterSubEntity>> PLAYER_WITHERED_DARK_MATTER_SUB = register("player_withered_dark_matter_sub",
			EntityType.Builder.<PlayerWitheredDarkMatterSubEntity>of(PlayerWitheredDarkMatterSubEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PerfectDarkMatterSubEntity>> PERFECT_DARK_MATTER_SUB = register("perfect_dark_matter_sub",
			EntityType.Builder.<PerfectDarkMatterSubEntity>of(PerfectDarkMatterSubEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PerfectDarkMatterMainEntity>> PERFECT_DARK_MATTER_MAIN = register("perfect_dark_matter_main",
			EntityType.Builder.<PerfectDarkMatterMainEntity>of(PerfectDarkMatterMainEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<HyperTrackerEntity>> HYPER_TRACKER = register("hyper_tracker",
			EntityType.Builder.<HyperTrackerEntity>of(HyperTrackerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).fireImmune().sized(2f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<TrackerMeteorEntity>> TRACKER_METEOR = register("tracker_meteor",
			EntityType.Builder.<TrackerMeteorEntity>of(TrackerMeteorEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TamableTrackerEntity>> TAMABLE_TRACKER = register("tamable_tracker",
			EntityType.Builder.<TamableTrackerEntity>of(TamableTrackerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.2f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<TamableTrackerMeteorEntity>> TAMABLE_TRACKER_METEOR = register("tamable_tracker_meteor",
			EntityType.Builder.<TamableTrackerMeteorEntity>of(TamableTrackerMeteorEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<HyperWitherWitherdDarkMatterClumpEntity>> HYPER_WITHER_WITHERD_DARK_MATTER_CLUMP = register("hyper_wither_witherd_dark_matter_clump",
			EntityType.Builder.<HyperWitherWitherdDarkMatterClumpEntity>of(HyperWitherWitherdDarkMatterClumpEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WeakTrackerEntity>> WEAK_TRACKER = register("weak_tracker",
			EntityType.Builder.<WeakTrackerEntity>of(WeakTrackerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<WeakFlyingTrackerEntity>> WEAK_FLYING_TRACKER = register("weak_flying_tracker",
			EntityType.Builder.<WeakFlyingTrackerEntity>of(WeakFlyingTrackerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.9f, 0.9f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		TrackerEntity.init(event);
		FlyingTrackerEntity.init(event);
		SuperTrackerEntity.init(event);
		HyperTrackerEntity.init(event);
		TamableTrackerEntity.init(event);
		WeakTrackerEntity.init(event);
		WeakFlyingTrackerEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TRACKER.get(), TrackerEntity.createAttributes().build());
		event.put(FLYING_TRACKER.get(), FlyingTrackerEntity.createAttributes().build());
		event.put(SUPER_TRACKER.get(), SuperTrackerEntity.createAttributes().build());
		event.put(HYPER_TRACKER.get(), HyperTrackerEntity.createAttributes().build());
		event.put(TAMABLE_TRACKER.get(), TamableTrackerEntity.createAttributes().build());
		event.put(WEAK_TRACKER.get(), WeakTrackerEntity.createAttributes().build());
		event.put(WEAK_FLYING_TRACKER.get(), WeakFlyingTrackerEntity.createAttributes().build());
	}
}
