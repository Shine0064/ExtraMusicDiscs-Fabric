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

public class MusicDiscs {

    private static final MusicDiscEntry[] MUSIC_DISC_LIST = {
        // Chiru-san
        new MusicDiscEntry("chiru_san_hiraeth",                 "Chiru-san",                "Hiraeth",                  245, "chiru_san_astral"),
        new MusicDiscEntry("chiru_san_restart",                 "Chiru-san",                "Restart",                  245),
        new MusicDiscEntry("chiru_san_forsaken",                "Chiru-san",                "Forsaken",                 257),
        new MusicDiscEntry("chiru_san_ghost",                   "Chiru-san",                "Ghost",                    216, "chiru_san_forsaken"),
        new MusicDiscEntry("chiru_san_aurora",                  "Chiru-san feat. MVRLY",    "Aurora",                   135),
        new MusicDiscEntry("chiru_san_cherry",                  "Chiru-san",                "Cherry",                   201),
        new MusicDiscEntry("chiru_san_possibility_space",       "Chiru-san",                "Possibility Space",        220),
        new MusicDiscEntry("chiru_san_inertia",                 "Chiru-san",                "Inertia",                  320),
        new MusicDiscEntry("chiru_san_skygazer",                "Chiru-san",                "Skygazer",                 182, "chiru_san_inertia"),
        new MusicDiscEntry("chiru_san_insomnia",                "Chiru-san",                "Insomnia",                 197, "chiru_san_inertia"),
        new MusicDiscEntry("chiru_san_astral",                  "Chiru-san",                "Astral",                   181),
        new MusicDiscEntry("chiru_san_mendacity",               "Chiru-san",                "Mendacity",                183),
        new MusicDiscEntry("chiru_san_luminescence",            "Chiru-san",                "Luminescence",             234),
        new MusicDiscEntry("chiru_san_akari",                   "Chiru-san",                "Akari",                    234),
        new MusicDiscEntry("chiru_san_bubbles",                 "Chiru-san",                "Bubbles",                  208, "chiru_san_voxel"),
        new MusicDiscEntry("chiru_san_moongazer",               "Chiru-san",                "Moongazer",                225, "chiru_san_voxel"),
        new MusicDiscEntry("chiru_san_voxel",                   "Chiru-san",                "Voxel",                    176),
        new MusicDiscEntry("chiru_san_catatonic",               "Chiru-san",                "Catatonic",                350),
        new MusicDiscEntry("chiru_san_1am",                     "Chiru-san",                "1AM",                      154),

        // Glitch Cat
        new MusicDiscEntry("glitch_cat_crush",                  "Glitch Cat",               "Crush",                    284),
        new MusicDiscEntry("glitch_cat_chasing_stars",          "Glitch Cat",               "Chasing Stars",            282),
        new MusicDiscEntry("glitch_cat_nexus",                  "Glitch Cat",               "Nexus",                    232),
        new MusicDiscEntry("glitch_cat_stuck_in_my_head",       "Glitch Cat",               "Stuck in my head",         215),
        new MusicDiscEntry("glitch_cat_ill_just_stop_thinking", "Glitch Cat",               "I'll just stop thinking",  216, "glitch_cat_stuck_in_my_head"),
        new MusicDiscEntry("glitch_cat_atychiphobia",           "Glitch Cat",               "Atychiphobia",             345, "glitch_cat_stuck_in_my_head"),
        new MusicDiscEntry("glitch_cat_life_the_illusion",      "Glitch Cat",               "Life the Illusion",        384, "glitch_cat_stuck_in_my_head"),
        new MusicDiscEntry("glitch_cat_false_dreams",           "Glitch Cat",               "false dreams",             119, "glitch_cat_stuck_in_my_head"),
        new MusicDiscEntry("glitch_cat_pastel_dreams",          "Glitch Cat",               "Pastel Dreams",            162, "glitch_cat_chasing_stars"),
    };

    public static final List<Item> MUSIC_DISCS = new ArrayList<>();
    public static final HashMap<MusicDiscEntry, Item> MUSIC_DISC_ENTRY_ITEM_MAP = new HashMap<>();
    public static final HashMap<String, Item> MUSIC_DISC_STRING_ITEM_MAP = new HashMap<>();

    public static void registerAllDiscs() {
        int compOutput = 1;
        for (MusicDiscEntry entry : MUSIC_DISC_LIST) {
            SoundEvent sound = ModSounds.registerSoundEvent("music_disc."+entry.name);

            Item i = registerMusicDisc(
                "music_disc_"+entry.name,
                compOutput,
                sound,
                entry.lengthInSeconds
            );

            MUSIC_DISC_ENTRY_ITEM_MAP.put(entry, i);
            MUSIC_DISC_STRING_ITEM_MAP.put(entry.name, i);
            if (compOutput >= 15)
                compOutput = 0;
            compOutput++;
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

        MUSIC_DISCS.add(i);

        return i;
    }
}