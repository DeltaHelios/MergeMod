package net.deltahelios.mergemod.item;

import net.deltahelios.mergemod.MergeMod;
import net.deltahelios.mergemod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CATALYST_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MergeMod.MOD_ID, "catalyst"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.catalyst"))
                    .icon(() -> new ItemStack(ModItems.EMPTY_CATALYST)).entries((displayContext, entries) -> {

                        entries.add(ModItems.EMPTY_CATALYST);
                        entries.add(ModItems.OPPOSITE_CATALYST);
                        entries.add(ModItems.SIMILAR_CATALYST);
                        entries.add(ModItems.SYMBIOSIS_CATALYST);
                        entries.add(ModItems.OVERGROWTH_CATALYST);
                        entries.add(ModItems.OVERFLOW_CATALYST);
                        entries.add(ModItems.OVERCHARGE_CATALYST);

                    }).build());
    public static final ItemGroup INGRIDIENTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MergeMod.MOD_ID, "ingridients"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ingridients"))
                    .icon(() -> new ItemStack(ModItems.STEEL_INGOT)).entries((displayContext, entries) -> {

                        entries.add(ModItems.BLAZING_COAL);
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.ROSE_GOLD_INGOT);
                        entries.add(ModItems.SILVER_INGOT);
                        entries.add(ModItems.RAW_SILVER);
                        entries.add(ModBlocks.ROSE_GOLD_BLOCK);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.SILVER_BLOCK);
                        entries.add(ModBlocks.SILVER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SILVER_ORE);


                    }).build());
    public static final ItemGroup TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MergeMod.MOD_ID, "tools"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tools"))
                    .icon(() -> new ItemStack(ModItems.TECTONIC_DETECTOR)).entries((displayContext, entries) -> {

                        entries.add(ModItems.TECTONIC_DETECTOR);
                        entries.add(ModItems.HEMLOCK_STAFF);

                    }).build());
    public static final ItemGroup BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MergeMod.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.SONIC_BOX)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.SONIC_BOX);


                    }).build());
    public static void registerItemGroups(){
        MergeMod.LOGGER.info("Registering Item Groups for "+ MergeMod.MOD_ID);
    }
}
