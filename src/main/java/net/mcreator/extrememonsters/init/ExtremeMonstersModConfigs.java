package net.mcreator.extrememonsters.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.extrememonsters.configuration.ExtremeMonstersConfigurationConfiguration;
import net.mcreator.extrememonsters.ExtremeMonstersMod;

@EventBusSubscriber(modid = ExtremeMonstersMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ExtremeMonstersModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("extreme_monsters").get().registerConfig(ModConfig.Type.SERVER, ExtremeMonstersConfigurationConfiguration.SPEC, "extreme_monsters_configuration_server.toml");
		});
	}
}
