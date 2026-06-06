package net.mcreator.extrememonsters.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;
import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShieldCapacityUpNumberProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ExtremeMonstersModItems.SUPER_DAMAGE_PROTECTOR.get())) : false) {
			if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity < 300) {
				{
					ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
					_vars.shield_capacity = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).shield_capacity < -20) {
				{
					ExtremeMonstersModVariables.PlayerVariables _vars = entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES);
					_vars.shield_capacity = -20;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
