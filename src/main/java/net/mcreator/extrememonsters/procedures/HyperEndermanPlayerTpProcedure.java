package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HyperEndermanPlayerTpProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double rx = 0;
		double rz = 0;
		if (sourceentity instanceof EnderMan && (sourceentity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS)
				? _livingEntity1.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).getBaseValue()
				: 0) == 1) {
			if (Math.random() >= 0.5) {
				rx = x + Mth.nextInt(RandomSource.create(), -10, 10);
				rz = z + Mth.nextInt(RandomSource.create(), -10, 10);
				if ((world.getBlockState(BlockPos.containing(rx, y, rz))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(rx, y + 1, rz))).getBlock() == Blocks.AIR) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.teleport")), SoundSource.HOSTILE, 1, (float) 1.2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.teleport")), SoundSource.HOSTILE, 1, (float) 1.2, false);
						}
					}
					{
						Entity _ent = entity;
						_ent.teleportTo(rx, y, rz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(rx, y, rz, _ent.getYRot(), _ent.getXRot());
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 20, 0.5, 1, 0.5, 0.2);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.REVERSE_PORTAL, rx, y, rz, 20, 0.5, 1, 0.5, 0.2);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLASH, rx, y, rz, 2, 0.5, 1, 0.5, 0.2);
				}
			}
		}
	}
}
