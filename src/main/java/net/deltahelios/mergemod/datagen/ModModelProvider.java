package net.deltahelios.mergemod.datagen;

import net.deltahelios.mergemod.MergeMod;
import net.deltahelios.mergemod.block.ModBlocks;
import net.deltahelios.mergemod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    private void fullBlock(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        blockStateModelGenerator.registerSimpleCubeAll(block);
        blockStateModelGenerator.registerParentedItemModel(block, new Identifier(MergeMod.MOD_ID, "block/" + Registries.BLOCK.getId(block).getPath()));
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        fullBlock(blockStateModelGenerator, ModBlocks.SILVER_BLOCK);
        fullBlock(blockStateModelGenerator, ModBlocks.SILVER_ORE);
        fullBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_SILVER_ORE);
        fullBlock(blockStateModelGenerator, ModBlocks.STEEL_BLOCK);
        fullBlock(blockStateModelGenerator, ModBlocks.ROSE_GOLD_BLOCK);
        fullBlock(blockStateModelGenerator, ModBlocks.SONIC_BOX);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLAZING_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TECTONIC_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELECTRUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.OPPOSITE_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEMLOCK_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.OVERCHARGE_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.OVERFLOW_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.OVERGROWTH_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SIMILAR_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.SYMBIOSIS_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.OVERSPELL_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TROPIC_INVOKER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELECTRO_RING, Models.GENERATED);

    }
}
