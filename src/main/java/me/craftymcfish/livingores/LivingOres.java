package me.craftymcfish.livingores;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivingOres implements ModInitializer {
	public static String MOD_ID = "livingores";
    public static final Logger LOGGER = LoggerFactory.getLogger(LivingOres.MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}