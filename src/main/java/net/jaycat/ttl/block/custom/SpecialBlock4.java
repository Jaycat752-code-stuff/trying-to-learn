package net.jaycat.ttl.block.custom;

import net.jaycat.ttl.block.ModBlocks;
import net.jaycat.ttl.item.ModItems;
import net.jaycat.ttl.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.Component;
import net.minecraft.component.ComponentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class SpecialBlock4 extends Block {

    public SpecialBlock4(Settings settings) {
        super(settings);
    }
    //use override here to show different helpful stuff or ctrl + alt + H

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;


    }



    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

if(entity instanceof ItemEntity itemEntity &&  !world.isClient()){

if(isValidItem(itemEntity.getStack())){


    world.setBlockState(pos, ModBlocks.COFFEE_MAKER_BLOCK.getDefaultState(), Block.NOTIFY_ALL);
    itemEntity.setStack(new ItemStack(Items.BUCKET, itemEntity.getStack().getCount()));
    world.playSound(null,  pos, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.BLOCKS, 1f, 0.5f);
    world.playSound(null,  pos, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.BLOCKS, 1f, 1f);
    world.playSound(null,  pos, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.BLOCKS, 1f, 1.5f);
}

}

        super.onSteppedOn(world, pos, state, entity);

    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isOf(Items.WATER_BUCKET);
        // isOf is for single items!
        // isIn for Tags!
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.ttl.coffee_maker_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
