package de.shine0064.extramusicdiscs.item;

import de.shine0064.extramusicdiscs.ExtraMusicDiscs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static de.shine0064.extramusicdiscs.util.MusicDiscs.*;

public class ModItemGroups {
    private static final List<String> USED_ITEMS = new ArrayList<>();

    public static final ItemGroup CHIRU_SAN_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(ExtraMusicDiscs.MOD_ID, "chiru_san_group"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.extramusicdiscs.chiru_san"))
            .icon(() -> new ItemStack(MUSIC_DISC_STRING_ITEM_MAP.get("chiru_san_cherry")))
            .entries((displayContext, entries) -> MUSIC_DISC_ENTRY_ITEM_MAP.forEach((entry, disc) -> {
                if (entry.artist.toLowerCase().contains("Chiru-san".toLowerCase())) {
                    entries.add(disc);
                    USED_ITEMS.add(entry.name);
                }
            }))
            .build()
    );

    public static final ItemGroup MVRLY_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(ExtraMusicDiscs.MOD_ID, "mvrly_group"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.extramusicdiscs.mvrly"))
            .icon(() -> new ItemStack(MUSIC_DISC_STRING_ITEM_MAP.get("chiru_san_aurora")))
            .entries((displayContext, entries) -> MUSIC_DISC_ENTRY_ITEM_MAP.forEach((entry, disc) -> {
                if (entry.artist.toLowerCase().contains("MVRLY".toLowerCase())) {
                    entries.add(disc);
                    USED_ITEMS.add(entry.name);
                }
            }))
            .build()
    );

    public static final ItemGroup GLITCH_CAT_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(ExtraMusicDiscs.MOD_ID, "glitch_cat_group"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.extramusicdiscs.glitch_cat"))
            .icon(() -> new ItemStack(MUSIC_DISC_STRING_ITEM_MAP.get("glitch_cat_nexus")))
            .entries((displayContext, entries) -> MUSIC_DISC_ENTRY_ITEM_MAP.forEach((entry, disc) -> {
                if (entry.artist.toLowerCase().contains("Glitch Cat".toLowerCase())) {
                    entries.add(disc);
                    USED_ITEMS.add(entry.name);
                }
            }))
            .build()
    );

    public static final ItemGroup OTHERS_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(ExtraMusicDiscs.MOD_ID, "others_group"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.extramusicdiscs.others"))
            .icon(() -> new ItemStack(MUSIC_DISCS.get(0)))
            .entries((displayContext, entries) -> MUSIC_DISC_ENTRY_ITEM_MAP.forEach((entry, disc) -> {
                if (!USED_ITEMS.contains(entry.name))
                    entries.add(disc);
            }))
            .build()
    );

    public static void registerItemGroups() {
        ExtraMusicDiscs.LOGGER.info("Registering item groups for " + ExtraMusicDiscs.MOD_ID);
    }
}
