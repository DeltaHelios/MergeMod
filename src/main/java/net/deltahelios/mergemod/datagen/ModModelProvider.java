package net.deltahelios.mergemod.datagen;

import net.deltahelios.mergemod.block.ModBlocks;
import net.deltahelios.mergemod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SONIC_BOX);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLAZING_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TECTONIC_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
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

    }
}
