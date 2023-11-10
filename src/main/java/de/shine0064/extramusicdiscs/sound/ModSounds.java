package de.shine0064.extramusicdiscs.sound;

import de.shine0064.extramusicdiscs.ExtraMusicDiscs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
//    public static final SoundEvent MUSIC_DISC_CHERRY = registerSoundEvent("music_disc.cherry");

    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ExtraMusicDiscs.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        ExtraMusicDiscs.LOGGER.info("Registering sounds for " + ExtraMusicDiscs.MOD_ID);
    }
}
