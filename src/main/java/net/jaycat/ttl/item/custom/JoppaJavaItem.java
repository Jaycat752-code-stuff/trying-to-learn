// Adding Special Item to Minecraft
package net.jaycat.ttl.item.custom;

import net.jaycat.ttl.block.ModBlocks;
import net.jaycat.ttl.TryingToLearn;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class JoppaJavaItem extends Item {
    private static final Map<Block, Block> JOPPA_JAVA_MAP =
            Map.of(
                    Blocks.BEDROCK, Blocks.AIR

            );

    public JoppaJavaItem(Settings settings) {
        super(settings);

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlocked = world.getBlockState(context.getBlockPos()).getBlock();

        if(JOPPA_JAVA_MAP.containsKey(clickedBlocked)){
            if(! world.isClient()) {
                world.setBlockState(context.getBlockPos(), JOPPA_JAVA_MAP.get(clickedBlocked).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS);


            }
            return ActionResult.SUCCESS;
        }


        return ActionResult.PASS;

    }
}
