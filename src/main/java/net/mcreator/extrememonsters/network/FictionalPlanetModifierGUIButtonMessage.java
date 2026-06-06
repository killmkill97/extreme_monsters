
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

import net.mcreator.extrememonsters.world.inventory.FictionalPlanetModifierGUIMenu;
import net.mcreator.extrememonsters.procedures.RarityRemoveProcedure;
import net.mcreator.extrememonsters.procedures.RarityAddProcedure;
import net.mcreator.extrememonsters.procedures.FPModifierApplyActionProcedure;
import net.mcreator.extrememonsters.procedures.DepthRemoveProcedure;
import net.mcreator.extrememonsters.procedures.DepthAddProcedure;
import net.mcreator.extrememonsters.procedures.DensityRemoveProcedure;
import net.mcreator.extrememonsters.procedures.DensityAddProcedure;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FictionalPlanetModifierGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FictionalPlanetModifierGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "fictional_planet_modifier_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FictionalPlanetModifierGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FictionalPlanetModifierGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FictionalPlanetModifierGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<FictionalPlanetModifierGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FictionalPlanetModifierGUIButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = FictionalPlanetModifierGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			FPModifierApplyActionProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			DepthAddProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			DensityAddProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			RarityAddProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			DepthRemoveProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			DensityRemoveProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			RarityRemoveProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ExtremeMonstersMod.addNetworkMessage(FictionalPlanetModifierGUIButtonMessage.TYPE, FictionalPlanetModifierGUIButtonMessage.STREAM_CODEC, FictionalPlanetModifierGUIButtonMessage::handleData);
	}
}
