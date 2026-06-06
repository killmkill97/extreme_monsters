package net.mcreator.extrememonsters.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.extrememonsters.ExtremeMonstersMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ExtremeMonstersModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ExtremeMonstersMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ExtremeMonstersMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		ExtremeMonstersMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.giveES = original.giveES;
			clone.allow_nether = original.allow_nether;
			clone.allow_end = original.allow_end;
			clone.basic_health = original.basic_health;
			clone.can_elytra_fly = original.can_elytra_fly;
			clone.flight_ring_bug_fix = original.flight_ring_bug_fix;
			clone.slash_all = original.slash_all;
			clone.perfect_abyss_despawn_mode = original.perfect_abyss_despawn_mode;
			clone.perfect_invincibility = original.perfect_invincibility;
			if (!event.isWasDeath()) {
				clone.tob_on_off = original.tob_on_off;
				clone.apc_on_off = original.apc_on_off;
				clone.nab_shot = original.nab_shot;
				clone.nab_shot_time = original.nab_shot_time;
				clone.ac_tick = original.ac_tick;
				clone.ac_second = original.ac_second;
				clone.mirror_of_despair_damage_saved = original.mirror_of_despair_damage_saved;
				clone.mirror_of_despair_work = original.mirror_of_despair_work;
				clone.mirror_of_despair_timer = original.mirror_of_despair_timer;
				clone.shield_capacity = original.shield_capacity;
				clone.test_qustn = original.test_qustn;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "extreme_monsters_worldvars";

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "extreme_monsters_mapvars";
		public boolean Extreme = false;
		public boolean is_killed_hyper_enderdragon = false;
		public boolean infinity_tracker_defender_working = false;
		public double after_extreme_mode_start = 0;
		public boolean spawn_basic_tracker = false;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			Extreme = nbt.getBoolean("Extreme");
			is_killed_hyper_enderdragon = nbt.getBoolean("is_killed_hyper_enderdragon");
			infinity_tracker_defender_working = nbt.getBoolean("infinity_tracker_defender_working");
			after_extreme_mode_start = nbt.getDouble("after_extreme_mode_start");
			spawn_basic_tracker = nbt.getBoolean("spawn_basic_tracker");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putBoolean("Extreme", Extreme);
			nbt.putBoolean("is_killed_hyper_enderdragon", is_killed_hyper_enderdragon);
			nbt.putBoolean("infinity_tracker_defender_working", infinity_tracker_defender_working);
			nbt.putDouble("after_extreme_mode_start", after_extreme_mode_start);
			nbt.putBoolean("spawn_basic_tracker", spawn_basic_tracker);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public boolean giveES = true;
		public boolean tob_on_off = false;
		public boolean apc_on_off = false;
		public boolean allow_nether = false;
		public boolean allow_end = false;
		public double basic_health = 0.0;
		public boolean nab_shot = false;
		public double nab_shot_time = 0;
		public double ac_tick = -1.0;
		public double ac_second = 0;
		public boolean can_elytra_fly = false;
		public boolean flight_ring_bug_fix = false;
		public double mirror_of_despair_damage_saved = 0;
		public boolean mirror_of_despair_work = false;
		public double mirror_of_despair_timer = 0;
		public double shield_capacity = 0.0;
		public boolean slash_all = false;
		public boolean perfect_abyss_despawn_mode = false;
		public boolean test_qustn = true;
		public boolean perfect_invincibility = true;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("giveES", giveES);
			nbt.putBoolean("tob_on_off", tob_on_off);
			nbt.putBoolean("apc_on_off", apc_on_off);
			nbt.putBoolean("allow_nether", allow_nether);
			nbt.putBoolean("allow_end", allow_end);
			nbt.putDouble("basic_health", basic_health);
			nbt.putBoolean("nab_shot", nab_shot);
			nbt.putDouble("nab_shot_time", nab_shot_time);
			nbt.putDouble("ac_tick", ac_tick);
			nbt.putDouble("ac_second", ac_second);
			nbt.putBoolean("can_elytra_fly", can_elytra_fly);
			nbt.putBoolean("flight_ring_bug_fix", flight_ring_bug_fix);
			nbt.putDouble("mirror_of_despair_damage_saved", mirror_of_despair_damage_saved);
			nbt.putBoolean("mirror_of_despair_work", mirror_of_despair_work);
			nbt.putDouble("mirror_of_despair_timer", mirror_of_despair_timer);
			nbt.putDouble("shield_capacity", shield_capacity);
			nbt.putBoolean("slash_all", slash_all);
			nbt.putBoolean("perfect_abyss_despawn_mode", perfect_abyss_despawn_mode);
			nbt.putBoolean("test_qustn", test_qustn);
			nbt.putBoolean("perfect_invincibility", perfect_invincibility);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			giveES = nbt.getBoolean("giveES");
			tob_on_off = nbt.getBoolean("tob_on_off");
			apc_on_off = nbt.getBoolean("apc_on_off");
			allow_nether = nbt.getBoolean("allow_nether");
			allow_end = nbt.getBoolean("allow_end");
			basic_health = nbt.getDouble("basic_health");
			nab_shot = nbt.getBoolean("nab_shot");
			nab_shot_time = nbt.getDouble("nab_shot_time");
			ac_tick = nbt.getDouble("ac_tick");
			ac_second = nbt.getDouble("ac_second");
			can_elytra_fly = nbt.getBoolean("can_elytra_fly");
			flight_ring_bug_fix = nbt.getBoolean("flight_ring_bug_fix");
			mirror_of_despair_damage_saved = nbt.getDouble("mirror_of_despair_damage_saved");
			mirror_of_despair_work = nbt.getBoolean("mirror_of_despair_work");
			mirror_of_despair_timer = nbt.getDouble("mirror_of_despair_timer");
			shield_capacity = nbt.getDouble("shield_capacity");
			slash_all = nbt.getBoolean("slash_all");
			perfect_abyss_despawn_mode = nbt.getBoolean("perfect_abyss_despawn_mode");
			test_qustn = nbt.getBoolean("test_qustn");
			perfect_invincibility = nbt.getBoolean("perfect_invincibility");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ExtremeMonstersMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
