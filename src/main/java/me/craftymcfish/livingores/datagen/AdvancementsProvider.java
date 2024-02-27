package me.craftymcfish.livingores.datagen;


import me.craftymcfish.livingores.LivingOres;
import me.craftymcfish.livingores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementManager;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.advancement.criterion.TravelCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.advancement.vanilla.VanillaStoryTabAdvancementGenerator;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class AdvancementsProvider extends FabricAdvancementProvider {

    public AdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        ModBlocks.LIVING_DIAMOND_ORE,
                        Text.translatable("advancements.living_ores.start_living_ores"),
                        Text.translatable("advancements.living_ores.start_living_ores.description"),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion("got_spore_block_icon", InventoryChangedCriterion.Conditions.items(Blocks.MOSS_BLOCK))
                .build(consumer, LivingOres.MOD_ID + "/root");

        Advancement livingSporeAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModBlocks.LIVING_SPORE,
                        Text.translatable("advancements.living_ores.pickup_living_spore"),
                        Text.translatable("advancements.living_ores.pickup_living_spore.description"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_spore_block", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_SPORE))
                .build(consumer, LivingOres.MOD_ID + "/got_spore_block");

        Advancement livingOresAdvancement = Advancement.Builder.create().parent(livingSporeAdvancement)
                .display(
                        ModBlocks.LIVING_QUARTZ_ORE,
                        Text.translatable("advancements.living_ores.pickup_all_living_ores"),
                        Text.translatable("advancements.living_ores.pickup_all_living_ores.description"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("got_living_coal_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_COAL_ORE))
                .criterion("got_living_lapis_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_LAPIS_ORE))
                .criterion("got_living_redstone_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_REDSTONE_ORE))
                .criterion("got_living_diamond_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_DIAMOND_ORE))
                .criterion("got_living_emerald_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_EMERALD_ORE))
                .criterion("got_living_iron_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_IRON_ORE))
                .criterion("got_living_copper_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_COPPER_ORE))
                .criterion("got_living_gold_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_GOLD_ORE))
                .criterion("got_living_quartz_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.LIVING_QUARTZ_ORE))
                .build(consumer, LivingOres.MOD_ID + "/got_all_ores");
    }
}