package net.deltahelios.mergemod.item;

import net.deltahelios.mergemod.MergeMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OPPOSITE_CATALYST = registerItem("opposite_catalyst", new Item(new FabricItemSettings()));
    public static final Item SIMILAR_CATALYST = registerItem("similar_catalyst", new Item(new FabricItemSettings()));
    private static void addItemsToIngridientItemGroup(FabricItemGroupEntries entries){
        entries.add(OPPOSITE_CATALYST);
        entries.add(SIMILAR_CATALYST);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MergeMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        MergeMod.LOGGER.info("Registering Mod Items for" + MergeMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngridientItemGroup);
    }
}
