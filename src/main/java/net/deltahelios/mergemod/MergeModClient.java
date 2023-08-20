package net.deltahelios.mergemod;

import net.deltahelios.mergemod.event.KeyInputHandler;
import net.deltahelios.mergemod.screen.AlloyForgeScreen;
import net.deltahelios.mergemod.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class MergeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        KeyInputHandler.register();

        HandledScreens.register(ModScreenHandlers.ALLOY_FORGE_SCREEN_HANDLER, AlloyForgeScreen::new);

}
}
