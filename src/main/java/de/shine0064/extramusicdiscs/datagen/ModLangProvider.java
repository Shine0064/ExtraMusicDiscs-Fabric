package de.shine0064.extramusicdiscs.datagen;

import de.shine0064.extramusicdiscs.ExtraMusicDiscs;
import de.shine0064.extramusicdiscs.util.MusicDiscs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangProvider extends FabricLanguageProvider {

    public ModLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemgroup.extramusicdiscs.chiru_san",   "§dExtra Music Discs: Chiru-san");
        translationBuilder.add("itemgroup.extramusicdiscs.mvrly",       "§dExtra Music Discs: MVRLY");
        translationBuilder.add("itemgroup.extramusicdiscs.glitch_cat",  "§dExtra Music Discs: Glitch Cat");
        translationBuilder.add("itemgroup.extramusicdiscs.others",      "§dExtra Music Discs: Others");

        MusicDiscs.MUSIC_DISC_ENTRY_ITEM_MAP.forEach((entry, disc) -> {
            translationBuilder.add(disc, "Music Disc");
            translationBuilder.add(
                String.format("item.%s.music_disc_%s.desc", ExtraMusicDiscs.MOD_ID, entry.name),
                String.format("%s - %s", entry.artist, entry.title)
            );
        });
    }
}
