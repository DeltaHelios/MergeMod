package net.deltahelios.mergemod.item;

import net.deltahelios.mergemod.MergeMod;
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
                    .icon(() -> new ItemStack(ModItems.OPPOSITE_CATALYST)).entries((displayContext, entries) -> {
                    entries.add(ModItems.OPPOSITE_CATALYST);
                    entries.add(ModItems.SIMILAR_CATALYST);
                    }).build());
    public static void registerItemGroups(){
        MergeMod.LOGGER.info("Registering Item Groups for "+ MergeMod.MOD_ID);
    }
}
