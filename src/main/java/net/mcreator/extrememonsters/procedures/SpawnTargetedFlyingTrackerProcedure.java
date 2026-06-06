package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SpawnTargetedFlyingTrackerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		double rx = 0;
		double rz = 0;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("summon extreme_monsters:flying_tracker " + (new Object() {
						public double getX() {
							try {
								return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getX();
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return 0;
							}
						}
					}.getX() + " ") + (new Object() {
						public double getY() {
							try {
								return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getY();
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return 0;
							}
						}
					}.getY() + " ") + (new Object() {
						public double getZ() {
							try {
								return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getZ();
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return 0;
							}
						}
					}.getZ() + " ") + "{NeoForgeData:{target:\"" + (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "target");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getStringUUID() + "\"}}"));
	}
}
