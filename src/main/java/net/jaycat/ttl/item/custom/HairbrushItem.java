// Adding Special Item to Minecraft
package net.jaycat.ttl.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;


public class HairbrushItem extends Item {

    public HairbrushItem(Settings settings){
super(settings);

    }


    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand ) {
World world = user.getWorld();


        if(entity instanceof HostileEntity){
            if(! world.isClient()) {

                ServerWorld serverWorld = (ServerWorld) world;


                world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.BLOCKS);

                entity.discard();

                stack.damage(1, serverWorld, (ServerPlayerEntity) user,
                        item -> user.sendEquipmentBreakStatus(item, hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.MAINHAND));

            }
            return ActionResult.SUCCESS;
        }



        return ActionResult.PASS;

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()){

            tooltip.add(Text.translatable("tooltip.ttl.hairbrush.shift_down"));
            tooltip.add(Text.translatable("tooltip.ttl.hairbrush.shift_down1"));
            tooltip.add(Text.translatable("tooltip.ttl.hairbrush.shift_down2"));
        }else {
            tooltip.add(Text.translatable("tooltip.ttl.hairbrush"));

        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
