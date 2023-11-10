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

import static de.shine0064.extramusicdiscs.util.MusicDiscs.Music_Discs;
import static de.shine0064.extramusicdiscs.util.MusicDiscs.Music_Discs_Map;

public class ModItemGroups {
    private static final List<String> USED_ITEMS = new ArrayList<>();

    public static final ItemGroup CHIRU_SAN = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(ExtraMusicDiscs.MOD_ID, "chiru_san_group"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.extramusicdiscs.chiru_san"))
            .icon(() -> new ItemStack(Music_Discs.get(0)))
            .entries((displayContext, entries) -> Music_Discs_Map.forEach((entry, disc) -> {
                if (entry.artist.contains("Chiru-san")) {
                    entries.add(disc);
                    USED_ITEMS.add(entry.name);
                }
            }))
            .build()
    );

    public static final ItemGroup DISC_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(ExtraMusicDiscs.MOD_ID, "others_group"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.extramusicdiscs.others"))
            .icon(() -> new ItemStack(Music_Discs.get(0)))
            .entries((displayContext, entries) -> Music_Discs_Map.forEach((entry, disc) -> {
                if (!USED_ITEMS.contains(entry.name))
                    entries.add(disc);
            }))
            .build()
    );

    public static void registerItemGroups() {
        ExtraMusicDiscs.LOGGER.info("Registering item groups for " + ExtraMusicDiscs.MOD_ID);
    }
}
