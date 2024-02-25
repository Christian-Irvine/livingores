package me.craftymcfish.livingores;

import me.craftymcfish.livingores.block.ModBlocks;
import me.craftymcfish.livingores.registry.ModItemGroups;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivingOres implements ModInitializer {
	public static String MOD_ID = "livingores";
    public static final Logger LOGGER = LoggerFactory.getLogger(LivingOres.MOD_ID);

	public static final GameRules.Key<GameRules.BooleanRule> EXHAUST_LIVING_ORES = registerBooleanGameRule("exhaustLivingOres", GameRules.Category.UPDATES, true);
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Living Ores");
		ModBlocks.registerBlocks();
		ModItemGroups.registerItemGroups();
	}

	public static GameRules.Key<GameRules.BooleanRule> registerBooleanGameRule(String name, GameRules.Category category, boolean defaultValue) {
		LivingOres.LOGGER.info("Registered " + name + " Gamerule");
		return GameRuleRegistry.register(name, category, GameRuleFactory.createBooleanRule(defaultValue));
	}
}