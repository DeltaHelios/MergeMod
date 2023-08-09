package net.deltahelios.mergemod;

import net.deltahelios.mergemod.block.ModBlocks;
import net.deltahelios.mergemod.item.ModItemGroups;
import net.deltahelios.mergemod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeMod implements ModInitializer {
	public static final String MOD_ID = "mergemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();

		FuelRegistry.INSTANCE.add(ModItems.BLAZING_COAL, 3200);

	}
}