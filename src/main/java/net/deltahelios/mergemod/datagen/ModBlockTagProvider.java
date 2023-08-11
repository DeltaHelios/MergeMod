package net.deltahelios.mergemod.datagen;

import net.deltahelios.mergemod.block.ModBlocks;
import net.deltahelios.mergemod.util.ModTags;
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
        getOrCreateTagBuilder(ModTags.Blocks.TECTONIC_DETECTOR_DETECTABLE_BLOCKS).add(ModBlocks.SILVER_ORE).add(ModBlocks.DEEPSLATE_SILVER_ORE).forceAddTag(BlockTags.GOLD_ORES).forceAddTag(BlockTags.EMERALD_ORES).forceAddTag(BlockTags.DIAMOND_ORES).forceAddTag(BlockTags.IRON_ORES).forceAddTag(BlockTags.LAPIS_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.SILVER_ORE).add(ModBlocks.DEEPSLATE_SILVER_ORE).add(ModBlocks.STEEL_BLOCK).add(ModBlocks.ROSE_GOLD_BLOCK);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.SONIC_BOX );
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SILVER_ORE).add(ModBlocks.DEEPSLATE_SILVER_ORE).add(ModBlocks.STEEL_BLOCK).add(ModBlocks.ROSE_GOLD_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.SONIC_BOX );
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));
    }
}
