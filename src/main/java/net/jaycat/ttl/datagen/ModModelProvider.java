package net.jaycat.ttl.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jaycat.ttl.block.ModBlocks;
import net.jaycat.ttl.block.custom.VeggieDiamondLamp;
import net.jaycat.ttl.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
BlockStateModelGenerator.BlockTexturePool veggieDiamondPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEGGIE_DIAMOND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_MAKER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_MAKER_BLOCK1);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_MAKER_BLOCK2);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COFFEE_MAKER_BLOCK3);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EMPTY_COFFEE_MAKER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VEGGIE_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VEGGIE_DIAMOND_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Counter_Top_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Wall_Block);

        blockStateModelGenerator.registerSimpleState(ModBlocks.PIZZA);


        veggieDiamondPool.stairs(ModBlocks.Veggie_DIAMOND_STAIRS);
        veggieDiamondPool.slab(ModBlocks.Veggie_DIAMOND_SLAB);

        veggieDiamondPool.fence(ModBlocks.Veggie_DIAMOND_FENCE);
        veggieDiamondPool.fenceGate(ModBlocks.Veggie_DIAMOND_FENCE_GATE);
        veggieDiamondPool.wall(ModBlocks.Veggie_DIAMOND_WALL);

        veggieDiamondPool.button(ModBlocks.Veggie_DIAMOND_BUTTON);
        veggieDiamondPool.pressurePlate(ModBlocks.Veggie_DIAMOND_PRESSURE_PLATE);


        blockStateModelGenerator.registerDoor(ModBlocks.Veggie_DIAMOND_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.Veggie_DIAMOND_TRAPDOOR);


        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.VEGGIE_DIAMOND_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.VEGGIE_DIAMOND_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.VEGGIE_DIAMOND_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(VeggieDiamondLamp.CLICKED, lampOnIdentifier, lampOffIdentifier)));
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

        itemModelGenerator.register(ModItems.VEGGIE_DIAMOND_AXE, Models.GENERATED);

    }



}
