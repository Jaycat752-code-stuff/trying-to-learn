package net.jaycat.ttl.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jaycat.ttl.block.ModBlocks;
import net.jaycat.ttl.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
    List<ItemConvertible> BURNING_HOT_VEGGIE_DIAMONDS_SMELTABLES = List.of(ModItems.VEGGIE_DIAMOND, ModBlocks.VEGGIE_DIAMOND_ORE,
            ModBlocks.VEGGIE_DIAMOND_DEEPSLATE_ORE);

    offerSmelting(exporter, BURNING_HOT_VEGGIE_DIAMONDS_SMELTABLES, RecipeCategory.MISC, ModItems.BURNING_HOT_VEGGIE_DIAMOND , 0.55f, 300, "burning_hot_veggie_diamond");
        offerBlasting(exporter, BURNING_HOT_VEGGIE_DIAMONDS_SMELTABLES, RecipeCategory.MISC, ModItems.BURNING_HOT_VEGGIE_DIAMOND , 0.55f, 150, "burning_hot_veggie_diamond");


        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VEGGIE_DIAMOND, RecipeCategory.DECORATIONS, ModBlocks.VEGGIE_DIAMOND_BLOCK);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.Counter_Top_Block)
                .pattern("VVV")
                .pattern("VSV")
                .pattern("VVV")
                .input('V', ModItems.VEGGIE_DIAMOND)
                .input('S', Items.STONE)
                .criterion(hasItem(ModItems.VEGGIE_DIAMOND), conditionsFromItem(ModItems.VEGGIE_DIAMOND))   // Unlocks recipe for counter_top_block if you have a veggie_diamond
                .offerTo(exporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VEGGIE_DIAMOND, 8)
                .input(ModBlocks.Counter_Top_Block)
                .criterion(hasItem(ModBlocks.Counter_Top_Block), conditionsFromItem(ModBlocks.Counter_Top_Block))
                .offerTo(exporter, Identifier.of("tll","veggie_diamond_from_counter_top_block"));




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.Wall_Block, 16)
                .pattern("SSS")
                .pattern("SVS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('V', ModItems.VEGGIE_DIAMOND)
                .criterion(hasItem(ModItems.VEGGIE_DIAMOND), conditionsFromItem(ModItems.VEGGIE_DIAMOND))   // Unlocks recipe for counter_top_block if you have a veggie_diamond
                .offerTo(exporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VEGGIE_DIAMOND, 1)
                .input(ModBlocks.COFFEE_MAKER_BLOCK)
                .criterion(hasItem(ModBlocks.COFFEE_MAKER_BLOCK), conditionsFromItem(ModBlocks.COFFEE_MAKER_BLOCK))
                .offerTo(exporter, Identifier.of("ttl", "veggie_diamond_from_coffee_maker"));

    }
}
