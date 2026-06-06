package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class QssNumberStateWhatIsThisProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal((("Pr: Processing Rate" + "\n") + "" + ("Sr: Success Rate" + "\n") + ("Dr: Determination Rate" + "\n") + ("Er: Error Rate" + "\n") + ("Rec: Recovery Error Rate" + "\n") + "Ept: Energy Per Tick")), false);
	}
}
