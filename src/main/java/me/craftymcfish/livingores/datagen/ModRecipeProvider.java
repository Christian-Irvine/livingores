package me.craftymcfish.livingores.datagen;

import me.craftymcfish.livingores.LivingOres;
import me.craftymcfish.livingores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.DEEPSLATE_COAL_ORE.asItem(), ModBlocks.LIVING_COAL_ORE.asItem(), "coal");
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.DEEPSLATE_COPPER_ORE.asItem(), ModBlocks.LIVING_COPPER_ORE.asItem(), "copper");
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.DEEPSLATE_IRON_ORE.asItem(), ModBlocks.LIVING_IRON_ORE.asItem(), "iron");
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.DEEPSLATE_GOLD_ORE.asItem(), ModBlocks.LIVING_GOLD_ORE.asItem(), "gold");
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.DEEPSLATE_DIAMOND_ORE.asItem(), ModBlocks.LIVING_DIAMOND_ORE.asItem(), "diamond");
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.DEEPSLATE_LAPIS_ORE.asItem(), ModBlocks.LIVING_LAPIS_ORE.asItem(), "lapis");
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.DEEPSLATE_REDSTONE_ORE.asItem(), ModBlocks.LIVING_REDSTONE_ORE.asItem(), "redstone");
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.DEEPSLATE_EMERALD_ORE.asItem(), ModBlocks.LIVING_EMERALD_ORE.asItem(), "emerald");
        offerLivingRecipe(exporter, RecipeCategory.MISC, Blocks.NETHER_QUARTZ_ORE.asItem(), ModBlocks.LIVING_QUARTZ_ORE.asItem(), "quartz");
    }


    public static void offerLivingRecipe(RecipeExporter exporter, RecipeCategory category, Item oreBlock, Item output, String name) {
        ShapedRecipeJsonBuilder.create(category, output, 1)
                .pattern("OMO")
                .pattern("MSM")
                .pattern("OMO")
                .input('O', oreBlock)
                .input('M', Blocks.MOSS_BLOCK)
                .input('S', ModBlocks.LIVING_SPORE)
                .criterion(hasItem(oreBlock), conditionsFromItem(oreBlock))
                .criterion(hasItem(ModBlocks.LIVING_SPORE), conditionsFromItem(ModBlocks.LIVING_SPORE))
                .offerTo(exporter, new Identifier(LivingOres.MOD_ID, "living_" + name + "_ore"));
    }


}
