package net.mcreator.extrememonsters.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ExtremeMonstersConfigurationConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> TRACKER_SPAWN;
	public static final ModConfigSpec.ConfigValue<Boolean> FLYING_TRACKER_SPAWN;
	public static final ModConfigSpec.ConfigValue<Boolean> FLYING_TRACKER_BREAK_BLOCK;
	public static final ModConfigSpec.ConfigValue<Boolean> HYPER_MOB_SPAWN;
	public static final ModConfigSpec.ConfigValue<Boolean> MACHINE_PARTICLE;
	public static final ModConfigSpec.ConfigValue<Boolean> ALWAYS_ALLOW_NETHER;
	public static final ModConfigSpec.ConfigValue<Boolean> ALWAYS_ALLOW_END;
	public static final ModConfigSpec.ConfigValue<Boolean> CAN_START_EXTREME;
	public static final ModConfigSpec.ConfigValue<Boolean> CAN_GET_EM_LOOT;
	static {
		BUILDER.push("mob_settings");
		TRACKER_SPAWN = BUILDER.comment("Whether the Tracker spawns").define("tracker spawn", true);
		FLYING_TRACKER_SPAWN = BUILDER.comment("Whether the only Flying Tracker spawns").define("flying tracker spawn", true);
		FLYING_TRACKER_BREAK_BLOCK = BUILDER.comment("Whether the flying tracker breaks blocks").define("flying tracker break block", true);
		HYPER_MOB_SPAWN = BUILDER.comment("Whether the Hyper Mob spawns. If you disable Hyper Mob spawning, Super Mobs will not appear either").define("hyper mob spawn", true);
		BUILDER.pop();
		BUILDER.push("game_play_settings");
		MACHINE_PARTICLE = BUILDER.comment("Whether the particle from machines").define("machine_particle", true);
		ALWAYS_ALLOW_NETHER = BUILDER.comment("Whether the allow Nether always").define("always allow Nether", false);
		ALWAYS_ALLOW_END = BUILDER.comment("Whether the allow End always").define("always allow End", false);
		CAN_START_EXTREME = BUILDER.comment("Whether the can start extreme").define("can start extreme", true);
		CAN_GET_EM_LOOT = BUILDER.comment("Whether can get Em loot when Extreme mode off").define("can get EM loot when off extreme mode", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
