package net.jaycat.ttl.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jaycat.ttl.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.VEGGIE_DIAMOND_BLOCK)
                .add(ModBlocks.VEGGIE_DIAMOND_ORE)
                .add(ModBlocks.VEGGIE_DIAMOND_DEEPSLATE_ORE)
                .add(ModBlocks.COFFEE_MAKER_BLOCK)
                .add(ModBlocks.COFFEE_MAKER_BLOCK1)
                .add(ModBlocks.COFFEE_MAKER_BLOCK2)
                .add(ModBlocks.COFFEE_MAKER_BLOCK3)
                .add(ModBlocks.EMPTY_COFFEE_MAKER_BLOCK)
                .add(ModBlocks.Counter_Top_Block)
                .add(ModBlocks.Wall_Block);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VEGGIE_DIAMOND_ORE)
                .add(ModBlocks.VEGGIE_DIAMOND_DEEPSLATE_ORE);
    }
}
