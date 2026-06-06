package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.ChatFormatting;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class GetTrackUUIDProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		MutableComponent track_uuid = Component.empty();
		track_uuid = Component.literal(((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "target");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getStringUUID()));
		track_uuid = new Object() {
			MutableComponent clickEvent(MutableComponent comp, ClickEvent.Action type, String value) {
				return comp.withStyle(_style -> _style.withClickEvent(new ClickEvent(type, value)));
			}
		}.clickEvent(track_uuid, ClickEvent.Action.COPY_TO_CLIPBOARD, ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "target");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getStringUUID()));
		track_uuid = new Object() {
			MutableComponent hoverEvent(MutableComponent comp, MutableComponent value) {
				return comp.withStyle(_style -> _style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, value)));
			}
		}.hoverEvent(track_uuid, Component.literal("Click to copy"));
		track_uuid = track_uuid.withStyle(ChatFormatting.GREEN);
		track_uuid = track_uuid.withStyle(ChatFormatting.UNDERLINE);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("this entity's track UUID is "), false);
		if (entity instanceof Player _player && !_player.level().isClientSide()) {
			_player.displayClientMessage(track_uuid, false);
		}
	}
}
