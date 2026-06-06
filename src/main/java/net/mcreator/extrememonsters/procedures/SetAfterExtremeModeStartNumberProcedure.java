package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.extrememonsters.network.ExtremeMonstersModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetAfterExtremeModeStartNumberProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		ExtremeMonstersModVariables.MapVariables.get(world).spawn_basic_tracker = false;
		ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("after extreme mode start is set to " + new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "number")))), false);
		ExtremeMonstersModVariables.MapVariables.get(world).after_extreme_mode_start = DoubleArgumentType.getDouble(arguments, "number");
		ExtremeMonstersModVariables.MapVariables.get(world).syncData(world);
	}
}
