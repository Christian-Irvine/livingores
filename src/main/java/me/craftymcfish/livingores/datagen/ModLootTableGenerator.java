package me.craftymcfish.livingores.datagen;

import me.craftymcfish.livingores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LIVING_DIAMOND_ORE, livingBlockDrops(Blocks.DEEPSLATE_DIAMOND_ORE, Items.DIAMOND, 1, 1));
        addDrop(ModBlocks.LIVING_GOLD_ORE, livingBlockDrops(Blocks.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD, 1, 1));
        addDrop(ModBlocks.LIVING_IRON_ORE, livingBlockDrops(Blocks.DEEPSLATE_IRON_ORE, Items.RAW_IRON, 1, 1));
        addDrop(ModBlocks.LIVING_COPPER_ORE, livingBlockDrops(Blocks.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER, 2, 5));
        addDrop(ModBlocks.LIVING_LAPIS_ORE, livingBlockDrops(Blocks.DEEPSLATE_LAPIS_ORE, Items.LAPIS_LAZULI, 4, 9));
        addDrop(ModBlocks.LIVING_REDSTONE_ORE, livingBlockDrops(Blocks.DEEPSLATE_REDSTONE_ORE, Items.REDSTONE, 4, 5));
        addDrop(ModBlocks.LIVING_COAL_ORE, livingBlockDrops(Blocks.DEEPSLATE_COAL_ORE, Items.COAL, 1, 1));
        addDrop(ModBlocks.LIVING_EMERALD_ORE, livingBlockDrops(Blocks.DEEPSLATE_EMERALD_ORE, Items.EMERALD, 1, 1));
        addDrop(ModBlocks.LIVING_QUARTZ_ORE, livingBlockDrops(Blocks.NETHER_QUARTZ_ORE, Items.QUARTZ, 1, 1));

        addDrop(ModBlocks.LIVING_SPORE);
    }


    public LootTable.Builder livingBlockDrops (Block baseBlock, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(baseBlock, (LootPoolEntry.Builder)this.applyExplosionDecay(baseBlock, ((LeafEntry.Builder) ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
