package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;

public class SayModTimerAndWorkAndDamageSaveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).mirror_of_despair_work) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("logic: true" + "\n" + "damage save: " + new java.text.DecimalFormat("##.##").format(entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).mirror_of_despair_damage_saved) + "\n"
						+ "timer: " + new java.text.DecimalFormat("##.##").format(entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).mirror_of_despair_timer))), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("logic: false" + "\n" + "damage save: " + new java.text.DecimalFormat("##.##").format(entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).mirror_of_despair_damage_saved) + "\n"
						+ "timer: " + new java.text.DecimalFormat("##.##").format(entity.getData(ExtremeMonstersModVariables.PLAYER_VARIABLES).mirror_of_despair_timer))), false);
		}
	}
}
