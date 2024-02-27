package me.craftymcfish.livingores.block;

import me.craftymcfish.livingores.LivingOres;
import me.craftymcfish.livingores.block.custom.LivingOreBlock;
import me.craftymcfish.livingores.block.custom.LivingSporeBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block LIVING_DIAMOND_ORE = registerBlock("living_diamond_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.DIAMOND),0.2f, 0.25f,0.2f, UniformIntProvider.create(3, 7)));
    public static final Block LIVING_GOLD_ORE = registerBlock("living_gold_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.RAW_GOLD),0.35f, 0.27f,0.12f));
    public static final Block LIVING_IRON_ORE = registerBlock("living_iron_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.RAW_IRON),0.7f, 0.27f,0.03f));
    public static final Block LIVING_COPPER_ORE = registerBlock("living_copper_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.COPPER_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.RAW_COPPER),0.85f, 0.27f,0.02f));
    public static final Block LIVING_LAPIS_ORE = registerBlock("living_lapis_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.LAPIS_LAZULI),0.3f, 0.26f,0.08f, UniformIntProvider.create(2, 5)));
    public static final Block LIVING_REDSTONE_ORE = registerBlock("living_redstone_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.REDSTONE),0.5f, 0.27f,0.07f, UniformIntProvider.create(2, 5)));
    public static final Block LIVING_COAL_ORE = registerBlock("living_coal_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.COAL),1f, 0.27f,-1.0f, UniformIntProvider.create(0, 2)));
    public static final Block LIVING_EMERALD_ORE = registerBlock("living_emerald_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.EMERALD),0.2f, 0.18f,0.25f, UniformIntProvider.create(3, 7)));
    public static final Block LIVING_QUARTZ_ORE = registerBlock("living_quartz_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK).requiresTool(), itemStack -> (itemStack == Items.QUARTZ),0.95f, 0.27f,-1.0f, UniformIntProvider.create(2, 5)));

    public static final Block LIVING_SPORE = registerBlock("living_spore",
            new LivingSporeBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).ticksRandomly().luminance(8).sounds(BlockSoundGroup.FROGLIGHT).requiresTool().strength(50.0f, 1200.0f)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(LivingOres.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(LivingOres.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {
        LivingOres.LOGGER.info("Successfully Registered Blocks");
    }
}
