package net.deltahelios.mergemod;

import net.deltahelios.mergemod.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class MergeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        KeyInputHandler.register();

}
}
