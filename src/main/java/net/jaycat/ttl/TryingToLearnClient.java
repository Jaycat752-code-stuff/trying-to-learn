package net.jaycat.ttl;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.jaycat.ttl.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class TryingToLearnClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Veggie_DIAMOND_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Veggie_DIAMOND_TRAPDOOR, RenderLayer.getCutout());


    }
}