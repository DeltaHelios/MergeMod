package net.deltahelios.mergemod.item.costum;

import net.minecraft.item.Item;

public class Catalyst extends Item {


    @Override
    public boolean isDamageable(){
        return true;
    }

    public Catalyst(Settings settings) {
        super(settings.maxCount(1).maxDamage(3));

    }
}
