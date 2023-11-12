package de.shine0064.extramusicdiscs;

import de.shine0064.extramusicdiscs.item.ModItemGroups;
import de.shine0064.extramusicdiscs.item.ModItems;
import de.shine0064.extramusicdiscs.loot.LootTableModifier;
import de.shine0064.extramusicdiscs.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraMusicDiscs implements ModInitializer {
	public static final String MOD_ID = "extramusicdiscs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModSounds.registerSounds();

		LootTableModifier.registerAllLootTableModifications();
	}
}