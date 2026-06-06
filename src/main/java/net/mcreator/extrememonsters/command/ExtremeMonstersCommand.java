
package net.mcreator.extrememonsters.command;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.extrememonsters.procedures.SpawnTargetedWeakTrackerProcedure;
import net.mcreator.extrememonsters.procedures.SpawnTargetedWeakFlyingTrackerProcedure;
import net.mcreator.extrememonsters.procedures.SpawnTargetedFlyingTrackerProcedure;
import net.mcreator.extrememonsters.procedures.SpawnTagetedTrackerProcedure;
import net.mcreator.extrememonsters.procedures.SetAfterExtremeModeStartNumberProcedure;
import net.mcreator.extrememonsters.procedures.SayModTimerAndWorkAndDamageSaveProcedure;
import net.mcreator.extrememonsters.procedures.ReappearanceOdrExplodeProcedure;
import net.mcreator.extrememonsters.procedures.KillItemProcedure;
import net.mcreator.extrememonsters.procedures.KillAllProcedure;
import net.mcreator.extrememonsters.procedures.HyperWitherTestProcedure;
import net.mcreator.extrememonsters.procedures.GetTrackUUIDProcedure;
import net.mcreator.extrememonsters.procedures.ExtremeCommandProcedure;
import net.mcreator.extrememonsters.procedures.ElytraFlyTrueFalseProcedure;
import net.mcreator.extrememonsters.procedures.DummyProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

@EventBusSubscriber
public class ExtremeMonstersCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("extreme_monsters").requires(s -> s.hasPermission(2)).then(Commands.literal("extreme_mode").then(Commands.argument("extreme_mode", BoolArgumentType.bool()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			ExtremeCommandProcedure.execute(world, arguments, entity);
			return 0;
		}))).then(Commands.literal("killall").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			KillAllProcedure.execute(entity);
			return 0;
		})).then(Commands.literal("killitem").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			KillItemProcedure.execute(entity);
			return 0;
		})).then(Commands.literal("dummy").then(Commands.argument("mob_name", StringArgumentType.word()).then(Commands.argument("count", DoubleArgumentType.doubleArg()).then(Commands.argument("nbts", MessageArgument.message()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DummyProcedure.execute(arguments, entity);
			return 0;
		}))))).then(Commands.literal("mirror_of_despair_test").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SayModTimerAndWorkAndDamageSaveProcedure.execute(entity);
			return 0;
		})).then(Commands.literal("elytra_fly").then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("elytra_fly", BoolArgumentType.bool()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			ElytraFlyTrueFalseProcedure.execute(arguments, entity);
			return 0;
		})))).then(Commands.literal("reappearance_odr_explode").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			ReappearanceOdrExplodeProcedure.execute(world, x, y, z);
			return 0;
		})).then(Commands.literal("hyper_wither_test").then(Commands.argument("target", EntityArgument.entity()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			HyperWitherTestProcedure.execute(arguments);
			return 0;
		}))).then(Commands.literal("set_after_extreme_mode_start").then(Commands.argument("number", DoubleArgumentType.doubleArg(0, 24000)).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SetAfterExtremeModeStartNumberProcedure.execute(world, arguments, entity);
			return 0;
		}))).then(Commands.literal("get_track_uuid").then(Commands.argument("target", EntityArgument.entity()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			GetTrackUUIDProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("summon_targeted_tracker").then(Commands.argument("pos", BlockPosArgument.blockPos()).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("tracker").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SpawnTagetedTrackerProcedure.execute(world, x, y, z, arguments);
			return 0;
		})).then(Commands.literal("flying_tracker").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SpawnTargetedFlyingTrackerProcedure.execute(world, x, y, z, arguments);
			return 0;
		})).then(Commands.literal("weak_tracker").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SpawnTargetedWeakTrackerProcedure.execute(world, x, y, z, arguments);
			return 0;
		})).then(Commands.literal("weak_flying_tracker").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SpawnTargetedWeakFlyingTrackerProcedure.execute(world, x, y, z, arguments);
			return 0;
		}))))));
	}
}
