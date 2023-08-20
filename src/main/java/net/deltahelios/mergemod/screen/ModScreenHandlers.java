package net.deltahelios.mergemod.screen;

import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<AlloyForgeScreenHandler> ALLOY_FORGE_SCREEN_HANDLER;

    public static void registerAllScreenHandlers(){
        ALLOY_FORGE_SCREEN_HANDLER= new ScreenHandlerType<>(AlloyForgeScreenHandler::new, FeatureSet.empty());
    }
}
