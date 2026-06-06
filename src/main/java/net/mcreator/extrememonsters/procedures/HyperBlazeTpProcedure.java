package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperBlazeTpProcedure {
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
		if (entity instanceof Blaze) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS) ? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue() : 0) == 1) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (entity.getPersistentData().getDouble("ability") <= 0) {
						entity.getPersistentData().putDouble("ability", 200);
					}
					if (entity.getPersistentData().getDouble("ability") >= 0) {
						entity.getPersistentData().putDouble("ability", (entity.getPersistentData().getDouble("ability") - 1));
					}
					if (entity.getPersistentData().getDouble("ability") <= 0) {
						rx = x + Mth.nextInt(RandomSource.create(), -10, 10);
						rz = z + Mth.nextInt(RandomSource.create(), -10, 10);
						if ((world.getBlockState(BlockPos.containing(rx, y, rz))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(rx, y + 1, rz))).getBlock() == Blocks.AIR) {
							{
								Entity _ent = entity;
								_ent.teleportTo(rx, y, rz);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(rx, y, rz, _ent.getYRot(), _ent.getXRot());
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 0.5, 1, 0.5, 0.2);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLAME, rx, y, rz, 20, 0.5, 1, 0.5, 0.2);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLASH, rx, y, rz, 2, 0.5, 1, 0.5, 0.2);
						}
					}
				}
			}
		}
	}
}
