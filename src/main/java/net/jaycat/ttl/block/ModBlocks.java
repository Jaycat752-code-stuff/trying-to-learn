package net.jaycat.ttl.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jaycat.ttl.TryingToLearn;
import net.jaycat.ttl.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
public static final Block Counter_Top_Block = registerBlock("counter_top_block",
        new Block(AbstractBlock.Settings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.NETHER_BRICKS)));


    public static final Block Wall_Block = registerBlock("wall_block",
            new Block(AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.STONE)));


    public static final Block VEGGIE_DIAMOND_ORE = registerBlock("veggie_diamond_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(15, 25),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block VEGGIE_DIAMOND_DEEPSLATE_ORE = registerBlock("veggie_diamond_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(27, 40),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

public static final Block VEGGIE_DIAMOND_BLOCK = registerBlock("veggie_diamond_block",
        new Block(AbstractBlock.Settings.create().strength(6f).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block COFFEE_MAKER_BLOCK = registerBlock("coffee_maker_block",
            new SpecialBlock(AbstractBlock.Settings.create().strength(1.5f).requiresTool()));


    public static final Block EMPTY_COFFEE_MAKER_BLOCK = registerBlock("empty_coffee_maker_block",
            new SpecialBlock4(AbstractBlock.Settings.create().strength(1.5f).requiresTool()));



    public static final Block Veggie_DIAMOND_STAIRS = registerBlock("veggie_diamond_stairs",
            new StairsBlock(ModBlocks.VEGGIE_DIAMOND_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(5.5f).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block Veggie_DIAMOND_SLAB = registerBlock("veggie_diamond_slab",
            new StairsBlock(ModBlocks.VEGGIE_DIAMOND_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)));



    public static final Block Veggie_DIAMOND_BUTTON = registerBlock("veggie_diamond_button",
           new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.create().strength(3f).requiresTool().noCollision()));

    public static final Block Veggie_DIAMOND_PESURE_PLATE = registerBlock("veggie_diamond_presure_plate",
            new PressurePlateBlock(BlockSetType.GOLD, AbstractBlock.Settings.create().strength(3f).requiresTool()));



    public static final Block Veggie_DIAMOND_FENCE = registerBlock("veggie_diamond_fence",
            new FenceBlock (AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block Veggie_DIAMOND_FENCE_GATE = registerBlock("veggie_diamond_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block Veggie_DIAMOND_WALL = registerBlock("veggie_diamond_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(6.5f).requiresTool().sounds(BlockSoundGroup.METAL)));




    public static final Block Veggie_DIAMOND_DOOR = registerBlock("veggie_diamond_door",
            new DoorBlock(BlockSetType.IRON,  AbstractBlock.Settings.create().strength(5.5f).requiresTool().sounds(BlockSoundGroup.METAL).nonOpaque()));

    public static final Block Veggie_DIAMOND_TRAPDOOR = registerBlock("veggie_diamond_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.METAL).nonOpaque()));










    public static final Block COFFEE_MAKER_BLOCK1 = registerBlock("coffee_maker_block1",
            new SpecialBlock1(AbstractBlock.Settings.create().strength(1.5f).requiresTool()));

    public static final Block COFFEE_MAKER_BLOCK2 = registerBlock("coffee_maker_block2",
            new SpecialBlock2(AbstractBlock.Settings.create().strength(1.5f).requiresTool()));

    public static final Block COFFEE_MAKER_BLOCK3 = registerBlock("coffee_maker_block3",
            new SpecialBlock3(AbstractBlock.Settings.create().strength(1.5f).requiresTool()));



    private static Block registerBlock(String name, Block block){
registerBlockItem(name, block);
return Registry.register(Registries.BLOCK,Identifier.of(TryingToLearn.MOD_ID, name),block );




    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TryingToLearn.MOD_ID, name),
       new BlockItem(block, new Item.Settings()));

    }

    public static void registerModBlocks(){
        TryingToLearn.LOGGER.info("Registering Mod Blocks for" + TryingToLearn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {


        });
    }

}
