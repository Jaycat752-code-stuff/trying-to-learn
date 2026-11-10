package net.jaycat.ttl;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.jaycat.ttl.block.ModBlocks;
import net.jaycat.ttl.item.ModItemGroups;
import net.jaycat.ttl.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;

public class TryingToLearn implements ModInitializer {
	public static final String MOD_ID = "ttl";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		FuelRegistry.INSTANCE.add(ModItems.BURNING_HOT_VEGGIE_DIAMOND, 2400 );
	}


}
