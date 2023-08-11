package net.deltahelios.mergemod.item;

import net.deltahelios.mergemod.MergeMod;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuels {
    public static void registerFuels(){
        FuelRegistry.INSTANCE.add(ModItems.BLAZING_COAL, 6400);
        MergeMod.LOGGER.info("Registering Fuel for "+ MergeMod.MOD_ID);
    }
}


