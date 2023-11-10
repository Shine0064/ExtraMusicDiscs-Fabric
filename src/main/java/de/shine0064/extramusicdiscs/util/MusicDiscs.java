package de.shine0064.extramusicdiscs.util;

import de.shine0064.extramusicdiscs.item.ModItems;
import de.shine0064.extramusicdiscs.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Rarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicDiscs {

    private static final MusicDiscEntry[] MUSIC_DISC_LIST = {
        new MusicDiscEntry("cherry",            "Chiru-san", "Cherry",              201, 1),
        new MusicDiscEntry("restart",           "Chiru-san", "Restart",             245, 2),
        new MusicDiscEntry("inertia",           "Chiru-san", "Inertia",             320, 3),
        new MusicDiscEntry("skygazer",          "Chiru-san", "Skygazer",            182, 4, "inertia"),
        new MusicDiscEntry("forsaken",          "Chiru-san", "Forsaken",            257, 5),
        new MusicDiscEntry("ghost",             "Chiru-san", "Ghost",               216, 6, "forsaken"),
        new MusicDiscEntry("insomnia",          "Chiru-san", "Insomnia",            197, 7, "inertia"),
        new MusicDiscEntry("possibility_space", "Chiru-san", "Possibility Space",   220, 8),
        new MusicDiscEntry("astral",            "Chiru-san", "Astral",              181, 9),
        new MusicDiscEntry("mendacity",         "Chiru-san", "Mendacity",           183, 10),
        new MusicDiscEntry("luminescence",      "Chiru-san", "Luminescence",        234, 11),
        new MusicDiscEntry("akari",             "Chiru-san", "Akari",               234, 12),
        new MusicDiscEntry("catatonic",         "Chiru-san", "Catatonic",           350, 13)
    };
    public static List<Item> Music_Discs = new ArrayList<>();
    public static Map<MusicDiscEntry, Item> Music_Discs_Map = new HashMap<>();

    public static void registerAllDiscs() {
        for(MusicDiscEntry musicDiscEntry : MUSIC_DISC_LIST) {
            SoundEvent sound = ModSounds.registerSoundEvent("music_disc."+musicDiscEntry.name);
            Item i = registerMusicDisc(
                "music_disc_"+musicDiscEntry.name,
                musicDiscEntry.compOutput,
                sound,
                musicDiscEntry.lengthInSeconds
            );

            Music_Discs_Map.put(musicDiscEntry, i);

        }
    }

    private static Item registerMusicDisc(String name, int compOutput, SoundEvent sound, int lengthInSeconds) {
        Item i = ModItems.registerItem(
            name,
            new MusicDiscItem(
                compOutput,
                sound,
                new FabricItemSettings()
                    .rarity(Rarity.EPIC)
                    .maxCount(1),
                lengthInSeconds
            )
        );

        Music_Discs.add(i);

        return i;
    }

    public static class MusicDiscEntry {
        public String name;
        public String artist;
        public String title;
        public String textureOverride;
        public int lengthInSeconds;
        public int compOutput;

        public MusicDiscEntry(
            String name,
            String artist,
            String title,
            int lengthInSeconds,
            int compOutput
        ) {
            this(name, artist, title, lengthInSeconds, compOutput, null);
        }
        public MusicDiscEntry(
            String name,
            String artist,
            String title,
            int lengthInSeconds,
            int compOutput,
            String textureOverride
        ) {
            this.name = name;
            this.artist = artist;
            this.title = title;
            this.lengthInSeconds = lengthInSeconds;
            this.compOutput = compOutput;
            this.textureOverride = textureOverride;
        }
    }
}