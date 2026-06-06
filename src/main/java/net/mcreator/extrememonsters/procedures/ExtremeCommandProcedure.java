package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class ExtremeCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (BoolArgumentType.getBool(arguments, "extreme_mode")) {
			ExtremeMonstersModVariables.MapVariables.get(world).Extreme = true;
			ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("extreme mode is set true."), false);
		} else {
			ExtremeMonstersModVariables.MapVariables.get(world).Extreme = false;
			ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("extreme mode is set false."), false);
			ExtremeMonstersModVariables.MapVariables.get(world).after_extreme_mode_start = 0;
			ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
