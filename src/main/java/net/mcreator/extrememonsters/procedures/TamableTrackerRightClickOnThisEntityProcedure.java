package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.extrememonsters.init.ExtremeMonstersModBlocks;

public class TamableTrackerRightClickOnThisEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
			if (itemstack.getItem() == ExtremeMonstersModBlocks.BLACK_HOLE_MATTER_BLOCK.get().asItem()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) != (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + Mth.nextDouble(RandomSource.create(), 2, 8)));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 0.2, 0.2, 0.2, 0);
				}
			} else if (itemstack.getItem() == Blocks.AIR.asItem()) {
				if (sourceentity.isShiftKeyDown()) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7aHealth: " + (new java.text.DecimalFormat("##.#").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + " / "
								+ (new java.text.DecimalFormat("##.#").format(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)))), true);
				} else {
					if (entity.getPersistentData().getBoolean("follow_owner")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Now it is don't following you"), true);
						entity.getPersistentData().putBoolean("follow_owner", false);
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Now it is following you"), true);
						entity.getPersistentData().putBoolean("follow_owner", true);
					}
				}
			}
		}
	}
}
