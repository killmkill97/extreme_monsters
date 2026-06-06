package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class MeltEffectProcedure {
	public static void execute(LevelAccessor world, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (!entity.isInWater()) {
			if (!world.getLevelData().isRaining() || !world.getLevelData().isThundering()) {
				entity.igniteForSeconds(5);
			}
		}
		if (entity.getPersistentData().getDouble("EMMeltDamageTimer") <= 0) {
			entity.getPersistentData().putDouble("EMMeltDamageTimer", 20);
		}
		if (entity.getPersistentData().getDouble("EMMeltDamageTimer") >= 0) {
			entity.getPersistentData().putDouble("EMMeltDamageTimer", (entity.getPersistentData().getDouble("EMMeltDamageTimer") - 1));
		}
		if (entity.getPersistentData().getDouble("EMMeltDamageTimer") <= 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("extreme_monsters:melted")))), (float) (2 * amplifier));
		}
	}
}
