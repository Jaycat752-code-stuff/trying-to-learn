package net.jaycat.ttl.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jaycat.ttl.block.ModBlocks;
import net.jaycat.ttl.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VEGGIE_DIAMOND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_MAKER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_MAKER_BLOCK1);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_MAKER_BLOCK2);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_MAKER_BLOCK3);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EMPTY_COFFEE_MAKER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VEGGIE_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VEGGIE_DIAMOND_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Counter_Top_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Wall_Block);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
itemModelGenerator.register(ModItems.BOB_THE_TOMATO, Models.GENERATED);
itemModelGenerator.register(ModItems.LARRY_THE_CUCUMBER, Models.GENERATED);
itemModelGenerator.register(ModItems.VEGGIE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIZZA_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.Hairbrush, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHERIFF_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNING_HOT_VEGGIE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.JOPPA_JAVA, Models.GENERATED);
        itemModelGenerator.register(ModItems.COFFEE_BEANS, Models.GENERATED);

    }
}
