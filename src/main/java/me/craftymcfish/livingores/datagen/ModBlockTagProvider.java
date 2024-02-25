package me.craftymcfish.livingores.datagen;

import me.craftymcfish.livingores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LIVING_DIAMOND_ORE)
                .add(ModBlocks.LIVING_GOLD_ORE)
                .add(ModBlocks.LIVING_IRON_ORE)
                .add(ModBlocks.LIVING_COPPER_ORE)
                .add(ModBlocks.LIVING_LAPIS_ORE)
                .add(ModBlocks.LIVING_REDSTONE_ORE)
                .add(ModBlocks.LIVING_COAL_ORE)
                .add(ModBlocks.LIVING_EMERALD_ORE)
                .add(ModBlocks.LIVING_QUARTZ_ORE)

                .add(ModBlocks.LIVING_SPORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.LIVING_SPORE);
    }
}