package me.craftymcfish.livingores.registry;

import me.craftymcfish.livingores.LivingOres;
import me.craftymcfish.livingores.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    private static final ItemGroup LIVING_ORES_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(Blocks.MOSS_BLOCK)).displayName(Text.translatable("itemGroup.livingores.livingores"))
            .entries((context, entries) -> {
                entries.add(ModBlocks.LIVING_COAL_ORE);
                entries.add(ModBlocks.LIVING_REDSTONE_ORE);
                entries.add(ModBlocks.LIVING_LAPIS_ORE);
                entries.add(ModBlocks.LIVING_DIAMOND_ORE);
                entries.add(ModBlocks.LIVING_EMERALD_ORE);
                entries.add(ModBlocks.LIVING_COPPER_ORE);
                entries.add(ModBlocks.LIVING_IRON_ORE);
                entries.add(ModBlocks.LIVING_GOLD_ORE);
                entries.add(ModBlocks.LIVING_QUARTZ_ORE);

                entries.add(ModBlocks.LIVING_SPORE);
            }).build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(LivingOres.MOD_ID, "no_more_horses"), LIVING_ORES_GROUP);
    }
}

