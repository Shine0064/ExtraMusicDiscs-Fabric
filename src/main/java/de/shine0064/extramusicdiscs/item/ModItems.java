package de.shine0064.extramusicdiscs.item;

import de.shine0064.extramusicdiscs.ExtraMusicDiscs;
import de.shine0064.extramusicdiscs.util.MusicDiscs;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

//    public static final Item MUSIC_DISC_CHERRY = registerItem(
//        "music_disc_cherry",
//        new MusicDiscItem(
//            1,
//            ModSounds.MUSIC_DISC_CHERRY,
//            new FabricItemSettings()
//                .rarity(Rarity.EPIC)
//                .maxCount(1),
//            201
//        )
//    );

    public static Item registerItem(String name, Item item) {
        return Registry.register(
            Registries.ITEM,
            new Identifier(
                ExtraMusicDiscs.MOD_ID,
                name
            ),
            item
        );
    }

    public static void registerModItems() {
        ExtraMusicDiscs.LOGGER.info("Registering mod items for " + ExtraMusicDiscs.MOD_ID);
        MusicDiscs.registerAllDiscs();
    }
}
