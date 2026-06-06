//package net.mcreator.extrememonsters.procedures;
//
//import net.neoforged.neoforge.event.tick.PlayerTickEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.bus.api.Event;
//
//import net.minecraft.world.phys.Vec3;
//import net.minecraft.world.phys.AABB;
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.GameType;
//import net.minecraft.world.level.ClipContext;
//import net.minecraft.world.item.component.CustomData;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
//import net.minecraft.world.entity.boss.EnderDragonPart;
//import net.minecraft.world.entity.Mob;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.damagesource.DamageSource;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.core.component.DataComponents;
//import net.minecraft.core.BlockPos;
//import net.minecraft.client.Minecraft;
//
//import net.mcreator.extrememonsters.item.InfernoDragonRailGunItem;
//import net.mcreator.extrememonsters.init.ExtremeMonstersModMobEffects;
//
//import javax.annotation.Nullable;
//
//import java.util.List;
//import java.util.Comparator;
//
//public class NoDamageEnderDragonBugFixProcedure {
//	public static void execute() {
//		if (entityiterator instanceof EnderDragon) {
//		    EnderDragon dragon = (EnderDragon) entityiterator;
//		    if (!dragon.level().isClientSide())
//		        dragon.hurt(dragon.damageSources().generic(), 100);
//		} 
//		// 새로 추가: 파트 감지
//		else if (entityiterator instanceof EnderDragonPart) {
//		    EnderDragonPart part = (EnderDragonPart) entityiterator;
//		    // EnderDragonPart에는 부모 드래곤 필드(예: parentMob, owner 등)가 존재함 — 네 매핑에 따라 필드명이 다를 수 있음
//		    EnderDragon parent = null;
//		    try {
//		        // 자바리플렉션으로 parent 필드 찾아보기 (필드명이 환경에 따라 다를 수 있어 안전 처리)
//		        java.lang.reflect.Field f = part.getClass().getDeclaredField("parentMob"); // 또는 "owner"
//		        f.setAccessible(true);
//		        Object o = f.get(part);
//		        if (o instanceof EnderDragon) parent = (EnderDragon) o;
//		    } catch (NoSuchFieldException | IllegalAccessException e) {
//		        // 리플렉션 실패 시 시도: getParent-like 메서드가 있으면 호출
//		    }
//		    if (parent != null && !parent.level().isClientSide())
//		       parent.hurt(parent.damageSources().generic(), 100);
//		}
//	}
//}
