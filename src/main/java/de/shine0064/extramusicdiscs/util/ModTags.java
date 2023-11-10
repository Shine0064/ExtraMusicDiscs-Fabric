package de.shine0064.extramusicdiscs.util;

import de.shine0064.extramusicdiscs.ExtraMusicDiscs;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> MUSIC_DISCS = createTag("music_discs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(ExtraMusicDiscs.MOD_ID, name));
        }
    }
}
