package me.craftymcfish.livingores.util;

import me.craftymcfish.livingores.LivingOres;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> LIVING_ORE_REPLACEABLES = createTag("living_ore_replaceables");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(LivingOres.MOD_ID, name));
        }
    }
}
