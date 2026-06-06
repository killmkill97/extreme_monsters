
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.extrememonsters.potion.UnresurrectMobEffect;
import net.mcreator.extrememonsters.potion.MeltMobEffect;
import net.mcreator.extrememonsters.potion.LongReachMobEffect;
import net.mcreator.extrememonsters.potion.ExplosiveMobEffect;
import net.mcreator.extrememonsters.potion.BlackHoleMobEffect;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

public class ExtremeMonstersModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, ExtremeMonstersMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> UNRESURRECT = REGISTRY.register("unresurrect", () -> new UnresurrectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MELT = REGISTRY.register("melt", () -> new MeltMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> EXPLOSIVE = REGISTRY.register("explosive", () -> new ExplosiveMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LONG_REACH = REGISTRY.register("long_reach", () -> new LongReachMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLACK_HOLE = REGISTRY.register("black_hole", () -> new BlackHoleMobEffect());
}
