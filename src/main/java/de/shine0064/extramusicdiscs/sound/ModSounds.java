package de.shine0064.extramusicdiscs.sound;

import de.shine0064.extramusicdiscs.ExtraMusicDiscs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ModSounds {
    public static HashMap<String, SoundEvent> SOUNDS = new HashMap<>();

    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ExtraMusicDiscs.MOD_ID, name);
        SoundEvent sound = Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
        SOUNDS.put(name, sound);
        return sound;
    }

    public static void registerSounds() {
        ExtraMusicDiscs.LOGGER.info("Registering sounds for " + ExtraMusicDiscs.MOD_ID);
    }
}
