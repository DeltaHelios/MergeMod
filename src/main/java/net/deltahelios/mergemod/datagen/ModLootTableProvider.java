package net.deltahelios.mergemod.datagen;

import net.deltahelios.mergemod.block.ModBlocks;
import net.deltahelios.mergemod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SILVER_ORE, oreDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER));
        addDrop(ModBlocks.DEEPSLATE_SILVER_ORE, oreDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER));

        addDrop(ModBlocks.SONIC_BOX);
        addDrop(ModBlocks.STEEL_BLOCK);
        addDrop(ModBlocks.ROSE_GOLD_BLOCK);
        addDrop(ModBlocks.SILVER_BLOCK);

    }
}
