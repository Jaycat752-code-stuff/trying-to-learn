package net.jaycat.ttl.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class PizzaBlock extends Block {
    public static final MapCodec<PizzaBlock> CODEC = createCodec(PizzaBlock::new);
    public static final int MAX_BITES = 5;
    public static final IntProperty BITES;
    public static final int DEFAULT_COMPARATOR_OUTPUT;
    protected static final float field_31047 = 1.0F;
    protected static final float field_31048 = 2.0F;
    protected static final VoxelShape[] BITES_TO_SHAPE;

    public MapCodec<PizzaBlock> getCodec() {
        return CODEC;
    }

    public PizzaBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BITES, 0));
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer)state.get(BITES)];
    }



    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return tryEat(world, pos, state, player);
    }

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(9, 0.55F);
            int i = (Integer)state.get(BITES);
            world.emitGameEvent(player, GameEvent.EAT, pos);
            if (i <= MAX_BITES) {
                world.setBlockState(pos, (BlockState)state.with(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return ActionResult.SUCCESS;
        }
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BITES});
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return getComparatorOutput((Integer)state.get(BITES));
    }

    public static int getComparatorOutput(int bites) {
        return (7 - bites) * 2;
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    static {
        BITES = Properties.BITES;
        DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(0);
        BITES_TO_SHAPE = new VoxelShape[]{Block.createCuboidShape((double)1.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)8.0F, (double)15.0F), Block.createCuboidShape((double)3.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)8.0F, (double)15.0F), Block.createCuboidShape((double)5.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)8.0F, (double)15.0F), Block.createCuboidShape((double)7.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)8.0F, (double)15.0F), Block.createCuboidShape((double)9.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)8.0F, (double)15.0F), Block.createCuboidShape((double)11.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)8.0F, (double)15.0F), Block.createCuboidShape((double)13.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)8.0F, (double)15.0F)};
    }
}
