//Adding 2 Creative Mod Tabs to Minecraft!
package net.jaycat.ttl.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jaycat.ttl.TryingToLearn;
import net.jaycat.ttl.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
public static final ItemGroup VEGGIETALES_ADVENTURES_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(TryingToLearn.MOD_ID, "veggietales_adventures_items" ),
        FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BOB_THE_TOMATO))
                .displayName(Text.translatable("itemgroup.ttl.veggietales_adventures_items"))
                .entries((displayContext, entries) -> {
entries.add(ModItems.BOB_THE_TOMATO);
entries.add(ModItems.LARRY_THE_CUCUMBER);
entries.add(ModItems.VEGGIE_DIAMOND);
entries.add(ModItems.SHERIFF_STAR);
entries.add(ModItems.JOPPA_JAVA);
entries.add(ModItems.COFFEE_BEANS);
entries.add(ModItems.Hairbrush);
entries.add(ModItems.PIZZA_SLICE);
entries.add(ModItems.BURNING_HOT_VEGGIE_DIAMOND);
                }).build());
// Adds a creative mod tab and puts 2 items in it


    public static final ItemGroup VEGGIETALES_ADVENTURES_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TryingToLearn.MOD_ID, "veggietales_adventures_blocks" ),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.Counter_Top_Block))
                    .displayName(Text.translatable("itemgroup.ttl.veggietales_adventures_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.Counter_Top_Block);
                        entries.add(ModBlocks.Wall_Block);
                        entries.add(ModBlocks.VEGGIE_DIAMOND_ORE);
                        entries.add(ModBlocks.VEGGIE_DIAMOND_DEEPSLATE_ORE);
                        entries.add(ModBlocks.VEGGIE_DIAMOND_BLOCK);
                        entries.add(ModBlocks.COFFEE_MAKER_BLOCK);
                        entries.add(ModBlocks.EMPTY_COFFEE_MAKER_BLOCK);

                        entries.add(ModBlocks.Veggie_DIAMOND_STAIRS);
                        entries.add(ModBlocks.Veggie_DIAMOND_SLAB);

                        entries.add(ModBlocks.Veggie_DIAMOND_BUTTON);
                        entries.add(ModBlocks.Veggie_DIAMOND_PESURE_PLATE);

                        entries.add(ModBlocks.Veggie_DIAMOND_FENCE);
                        entries.add(ModBlocks.Veggie_DIAMOND_FENCE_GATE);
                        entries.add(ModBlocks.Veggie_DIAMOND_WALL);

                        entries.add(ModBlocks.Veggie_DIAMOND_DOOR);
                        entries.add(ModBlocks.Veggie_DIAMOND_TRAPDOOR);

                    }).build());
    // Adds another creative mod tab and puts 2 items in it
    public static void registerItemGroups() {

        TryingToLearn.LOGGER.info("Registering Item Groups for " + TryingToLearn.MOD_ID);


    }


}
