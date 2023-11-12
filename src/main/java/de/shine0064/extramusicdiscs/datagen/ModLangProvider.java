package de.shine0064.extramusicdiscs.datagen;

import de.shine0064.extramusicdiscs.ExtraMusicDiscs;
import de.shine0064.extramusicdiscs.util.MusicDiscs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;
import java.util.Optional;

public class ModLangProvider extends FabricLanguageProvider {

    public ModLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemgroup.extramusicdiscs.chiru_san",   "§dExtra Music Discs: Chiru-san");
        translationBuilder.add("itemgroup.extramusicdiscs.mvrly",       "§dExtra Music Discs: MVRLY");
        translationBuilder.add("itemgroup.extramusicdiscs.others",      "§dExtra Music Discs: Others");

        MusicDiscs.Music_Discs_Map.forEach((entry, disc) -> {
            translationBuilder.add(disc, "Music Disc");
            translationBuilder.add(
                String.format("item.%s.music_disc_%s.desc", ExtraMusicDiscs.MOD_ID, entry.name),
                String.format("%s - %s", entry.artist, entry.title)
            );
        });

        try {
            Optional<Path> path = dataOutput.getModContainer().findPath("assets/"+ ExtraMusicDiscs.MOD_ID +"/lang/en_us_existing.json");
            if(path.isPresent()) {
                Path existingFilePath = path.get();
                translationBuilder.add(existingFilePath);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
