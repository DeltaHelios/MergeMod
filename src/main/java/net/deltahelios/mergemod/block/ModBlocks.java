package net.deltahelios.mergemod.block;

import net.deltahelios.mergemod.MergeMod;
import net.deltahelios.mergemod.block.costum.AlloyForgeBlock;
import net.deltahelios.mergemod.block.costum.SonicBoxBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block SONIC_BOX = registerBlock("sonic_box", new SonicBoxBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK)));
    public static final Block STEEL_BLOCK = registerBlock("steel_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block SILVER_ORE = registerBlock("silver_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE), UniformIntProvider.create(2,6)));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE), UniformIntProvider.create(2,6)));
    public static final Block SILVER_BLOCK = registerBlock("silver_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ALLOY_FORGE = registerBlock("alloy_forge", new AlloyForgeBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MergeMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(MergeMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        MergeMod.LOGGER.info("Registering Blocks for "+MergeMod.MOD_ID);
    }
}
