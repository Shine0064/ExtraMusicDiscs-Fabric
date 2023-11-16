package de.shine0064.extramusicdiscs.datagen;

import de.shine0064.extramusicdiscs.sound.ModSounds;
import de.shine0064.extramusicdiscs.util.FabricSoundProvider;
import de.shine0064.extramusicdiscs.util.MusicDiscs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static de.shine0064.extramusicdiscs.ExtraMusicDiscs.MOD_ID;

public class ModSoundProvider extends FabricSoundProvider {

    public ModSoundProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateSounds(SoundBuilder soundBuilder) {
        MusicDiscs.MUSIC_DISC_ENTRY_ITEM_MAP.forEach((entry, disc) -> {
            SoundEvent sound = ModSounds.SOUNDS.get("music_disc."+entry.name);
            SoundEntry soundEntry = new SoundEntry(new Identifier(MOD_ID, "records/"+entry.name), true);
            soundBuilder.add(sound, false, soundEntry);
        });
    }
}
