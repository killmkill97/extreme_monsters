package net.mcreator.extrememonsters.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class YPosAutoSenttingProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (CanStringConvertNumberProcedure.execute(guistate.containsKey("text:tx") ? ((EditBox) guistate.get("text:tx")).getValue() : "")
				&& CanStringConvertNumberProcedure.execute(guistate.containsKey("text:tz") ? ((EditBox) guistate.get("text:tz")).getValue() : "")) {
			if (guistate.get("text:ty") instanceof EditBox _tf)
				_tf.setValue((new java.text.DecimalFormat("##").format(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:tx") ? ((EditBox) guistate.get("text:tx")).getValue() : ""), (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:tz") ? ((EditBox) guistate.get("text:tz")).getValue() : "")))));
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cInvalid character"), true);
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
