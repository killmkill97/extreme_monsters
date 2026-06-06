
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.extrememonsters.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.extrememonsters.network.PerfectInvincibilityToggleMessage;
import net.mcreator.extrememonsters.network.MagnetToggleMessage;
import net.mcreator.extrememonsters.network.ExtraFunctionMessage;
import net.mcreator.extrememonsters.network.ChangeModeMessage;
import net.mcreator.extrememonsters.network.AntiTrackerItemActionMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ExtremeMonstersModKeyMappings {
	public static final KeyMapping EXTRA_FUNCTION = new KeyMapping("key.extreme_monsters.extra_function", GLFW.GLFW_KEY_C, "key.categories.extreme_monsters") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ExtraFunctionMessage(0, 0));
				ExtraFunctionMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ANTI_TRACKER_ITEM_ACTION = new KeyMapping("key.extreme_monsters.anti_tracker_item_action", GLFW.GLFW_KEY_Z, "key.categories.extreme_monsters") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new AntiTrackerItemActionMessage(0, 0));
				AntiTrackerItemActionMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CHANGE_MODE = new KeyMapping("key.extreme_monsters.change_mode", GLFW.GLFW_KEY_V, "key.categories.extreme_monsters") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ChangeModeMessage(0, 0));
				ChangeModeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MAGNET_TOGGLE = new KeyMapping("key.extreme_monsters.magnet_toggle", GLFW.GLFW_KEY_X, "key.categories.extreme_monsters") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MagnetToggleMessage(0, 0));
				MagnetToggleMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PERFECT_INVINCIBILITY_TOGGLE = new KeyMapping("key.extreme_monsters.perfect_invincibility_toggle", GLFW.GLFW_KEY_B, "key.categories.extreme_monsters") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new PerfectInvincibilityToggleMessage(0, 0));
				PerfectInvincibilityToggleMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(EXTRA_FUNCTION);
		event.register(ANTI_TRACKER_ITEM_ACTION);
		event.register(CHANGE_MODE);
		event.register(MAGNET_TOGGLE);
		event.register(PERFECT_INVINCIBILITY_TOGGLE);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				EXTRA_FUNCTION.consumeClick();
				ANTI_TRACKER_ITEM_ACTION.consumeClick();
				CHANGE_MODE.consumeClick();
				MAGNET_TOGGLE.consumeClick();
				PERFECT_INVINCIBILITY_TOGGLE.consumeClick();
			}
		}
	}
}
