package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModAttributes;
import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SuperCreeperProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (ExtremeMonstersConfigurationConfiguration.HYPER_MOB_SPAWN.get()) {
			if (ExtremeMonstersModVariables.MapVariables.get(world).Extreme) {
				if (entity instanceof Creeper) {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data modify entity @s powered set value true");
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(ExtremeMonstersModAttributes.HYPER_MOBS))
								_livingEntity5.getAttribute(ExtremeMonstersModAttributes.HYPER_MOBS).setBaseValue(1);
							if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
								_livingEntity6.getAttribute(Attributes.MAX_HEALTH).setBaseValue(200);
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth(200);
						}
					}
				}
			}
		}
	}
}
