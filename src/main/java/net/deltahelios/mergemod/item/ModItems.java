package net.deltahelios.mergemod.item;

import net.deltahelios.mergemod.MergeMod;
import net.deltahelios.mergemod.item.costum.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item OPPOSITE_CATALYST = registerItem("opposite_catalyst", new Catalyst(new FabricItemSettings()));
    public static final Item SIMILAR_CATALYST = registerItem("similar_catalyst", new Catalyst(new FabricItemSettings()));
    public static final Item EMPTY_CATALYST = registerItem("empty_catalyst", new Item(new FabricItemSettings()));
    public static final Item SYMBIOSIS_CATALYST = registerItem("symbiosis_catalyst", new Catalyst(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item OVERGROWTH_CATALYST = registerItem("overgrowth_catalyst", new Catalyst(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item OVERFLOW_CATALYST = registerItem("overflow_catalyst", new Catalyst(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item OVERCHARGE_CATALYST = registerItem("overcharge_catalyst", new Catalyst(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item OVERSPELL_CATALYST = registerItem("overspell_catalyst", new Catalyst(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item BLAZING_COAL = registerItem("blazing_coal", new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings()));
    public static final Item ELECTRUM_INGOT = registerItem("electrum_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new FabricItemSettings()));
    public static final Item TECTONIC_DETECTOR = registerItem("tectonic_detector", new TectonicDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item HEMLOCK_STAFF= registerItem("hemlock_staff", new HemlockStaffItem(ToolMaterials.WOOD, 4, -3.5f, new FabricItemSettings().maxDamage(128)));
    public static final Item TROPIC_INVOKER = registerItem("tropic_invoker", new TropicInvokerItem(new FabricItemSettings().maxDamage(64).rarity(Rarity.RARE)));
    public static final Item ELECTRO_RING = registerItem("electro_ring", new ElectroRingItem(new FabricItemSettings().maxDamage(64).rarity(Rarity.RARE)));


    private static void addItemsToIngridientItemGroup(FabricItemGroupEntries entries){

        entries.add(TECTONIC_DETECTOR);

        entries.add(OPPOSITE_CATALYST);
        entries.add(SIMILAR_CATALYST);
        entries.add(EMPTY_CATALYST);
        entries.add(SYMBIOSIS_CATALYST);
        entries.add(OVERFLOW_CATALYST);
        entries.add(OVERGROWTH_CATALYST);

        entries.add(STEEL_INGOT);
        entries.add(ROSE_GOLD_INGOT);
        entries.add(SILVER_INGOT);

        entries.add(RAW_SILVER);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MergeMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        MergeMod.LOGGER.info("Registering Mod Items for" + MergeMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngridientItemGroup);
    }
}
