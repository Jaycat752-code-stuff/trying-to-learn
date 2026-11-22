// Adding Items to Minecraft!
package net.jaycat.ttl.item;


import java.util.List;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jaycat.ttl.TryingToLearn;
import net.jaycat.ttl.item.custom.HairbrushItem;
import net.jaycat.ttl.item.custom.JoppaJavaItem;
import net.jaycat.ttl.item.custom.ModToolMaterials;
import net.jaycat.ttl.item.custom.SheriffStarItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
public static final Item BOB_THE_TOMATO = registerItem("bob_the_tomato", new Item(new Item.Settings().fireproof()));
public static final Item LARRY_THE_CUCUMBER = registerItem("larry_the_cucumber", new Item(new Item.Settings().fireproof()));
public static final Item VEGGIE_DIAMOND = registerItem("veggie_diamond", new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)));
public static final Item COFFEE_BEANS = registerItem("coffee_beans", new Item (new Item.Settings()));

// Adds the Items

    public static final Item SHERIFF_STAR = registerItem("sheriff_star", new SheriffStarItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(132)));

    public static final Item JOPPA_JAVA = registerItem("joppa_java", new JoppaJavaItem(new Item.Settings().maxDamage(82)));

    public static final Item Hairbrush = registerItem("hairbrush", new HairbrushItem(new Item.Settings().maxDamage(850).rarity(Rarity.RARE)));


public static final Item PIZZA_SLICE = registerItem("pizza_slice", new Item(new Item.Settings().food(ModFoodComponents.PIZZA_SLICE)){
    @Override // meehhhh I don't want to do what my parents (classes) do I want to do my own methods!
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.ttl.pizza_slice.tooltip"));
        tooltip.add(Text.translatable("tooltip.ttl.pizza_slice.tooltip1"));

        super.appendTooltip(stack, context, tooltip, type); // actually I want to do some of my parent's stuff!
    }

// I'm inside an anonymous class, a guy to write classes 'on the fly' just like a grab and go snack!
});


    public static final Item BURNING_HOT_VEGGIE_DIAMOND = registerItem("burning_hot_veggie_diamond", new Item(new Item.Settings()));

    public static final Item VEGGIE_DIAMOND_SWORD = registerItem("veggie_diamond_sword",
            new SwordItem(ModToolMaterials.VEGGIE_DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.VEGGIE_DIAMOND, 2, -2.7f)))); // these numbers are for additional damage and attack speed!!!!

    public static final Item VEGGIE_DIAMOND_PICKAXE = registerItem("veggie_diamond_pickaxe",
            new PickaxeItem(ModToolMaterials.VEGGIE_DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.VEGGIE_DIAMOND, 1, -3.1f)))); // these numbers are for additional damage and attack speed!!!!

    public static final Item VEGGIE_DIAMOND_SHOVEL = registerItem("veggie_diamond_shovel",
            new ShovelItem(ModToolMaterials.VEGGIE_DIAMOND, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.VEGGIE_DIAMOND, 1.5f, -3.3f)))); // these numbers are for additional damage and attack speed!!!!

    public static final Item VEGGIE_DIAMOND_AXE = registerItem("veggie_diamond_axe",
            new AxeItem(ModToolMaterials.VEGGIE_DIAMOND, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.VEGGIE_DIAMOND, 5, -3.5f))));

    public static final Item VEGGIE_DIAMOND_HOE = registerItem("veggie_diamond_hoe",
            new HoeItem(ModToolMaterials.VEGGIE_DIAMOND, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.VEGGIE_DIAMOND, 0, -3.3f))));

    private static Item registerItem(String name, Item item) {

    return Registry.register(Registries.ITEM, Identifier.of(TryingToLearn.MOD_ID, name), item);
}

    public static void registerModItems(){

        TryingToLearn.LOGGER.info("Registering Mod Items for" + TryingToLearn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

            // Adds them to the Ingredients Creative Tab

        });
    }

}
