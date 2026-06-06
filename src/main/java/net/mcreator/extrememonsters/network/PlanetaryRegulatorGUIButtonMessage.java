
package net.mcreator.extrememonsters.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.extrememonsters.world.inventory.PlanetaryRegulatorGUIMenu;
import net.mcreator.extrememonsters.procedures.WeatherClearButtonProcedure;
import net.mcreator.extrememonsters.procedures.PlanetaryRegulatorSetToNightProcedure;
import net.mcreator.extrememonsters.procedures.PlanetaryRegulatorSetToDayProcedure;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record PlanetaryRegulatorGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<PlanetaryRegulatorGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "planetary_regulator_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PlanetaryRegulatorGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlanetaryRegulatorGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PlanetaryRegulatorGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<PlanetaryRegulatorGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PlanetaryRegulatorGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = PlanetaryRegulatorGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PlanetaryRegulatorSetToDayProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			PlanetaryRegulatorSetToNightProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			WeatherClearButtonProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ExtremeMonstersMod.addNetworkMessage(PlanetaryRegulatorGUIButtonMessage.TYPE, PlanetaryRegulatorGUIButtonMessage.STREAM_CODEC, PlanetaryRegulatorGUIButtonMessage::handleData);
	}
}
