package de.shine0064.extramusicdiscs;

import de.shine0064.extramusicdiscs.datagen.ModItemTagProvider;
import de.shine0064.extramusicdiscs.datagen.ModLangProvider;
import de.shine0064.extramusicdiscs.datagen.ModModelProvider;
import de.shine0064.extramusicdiscs.datagen.ModSoundProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ExtraMusicDiscsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLangProvider::new);
		pack.addProvider(ModSoundProvider::new);
	}
}
