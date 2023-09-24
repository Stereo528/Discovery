package com.stereo528.discovery;

import eu.midnightdust.lib.config.MidnightConfig;
import com.stereo528.discovery.Config.ModConfig;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

import static com.stereo528.discovery.Discovery.MODID;

public class DiscoveryClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {
		MidnightConfig.init(MODID, ModConfig.class);
	}
}
