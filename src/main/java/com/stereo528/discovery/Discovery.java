package com.stereo528.discovery;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Discovery implements ModInitializer {
	public static final String MODID = "discovery";
	public static final Logger LOGGER = LoggerFactory.getLogger("Discovery");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Are ya ready to go on some Discovery kids?");
	}
}
