package net.deltahelios.mergemod.datagen;

import net.deltahelios.mergemod.block.ModBlocks;
import net.deltahelios.mergemod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static List<ItemConvertible> SILVER_SMELTABLES= List.of(ModItems.RAW_SILVER, ModBlocks.DEEPSLATE_SILVER_ORE, ModBlocks.SILVER_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT, 2.5f, 200, "silver" );
        offerBlasting(exporter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT, 2.5f, 200, "silver" );
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ROSE_GOLD_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_GOLD_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OPPOSITE_CATALYST, 1).pattern("#B#").pattern("#G#").pattern("#I#").input('#', ModItems.STEEL_INGOT).input('B', Items.BLAZE_POWDER).input('G', Items.GLASS_PANE).input('I',Items.ICE).criterion(hasItem(Items.ICE), conditionsFromItem(Items.ICE)).criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER)).criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT)).offerTo(exporter, new Identifier(getRecipeName(ModItems.OPPOSITE_CATALYST)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SIMILAR_CATALYST, 1).pattern("#A#").pattern("#G#").pattern("#E#").input('#', ModItems.STEEL_INGOT).input('A', Items.AMETHYST_SHARD).input('G', Items.GLASS_PANE).input('E',Items.EMERALD);
    }
}
