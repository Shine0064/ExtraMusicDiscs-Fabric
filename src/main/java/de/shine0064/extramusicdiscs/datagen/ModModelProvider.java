package de.shine0064.extramusicdiscs.datagen;

import de.shine0064.extramusicdiscs.util.MusicDiscs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        MusicDiscs.Music_Discs_Map.forEach((entry, disc) -> {
            if (entry.textureOverride != null) {
                final Item[] texture = new Item[1];
                MusicDiscs.Music_Discs_Map.forEach((entry2, i) -> {
                    if (entry2.name.equals(entry.textureOverride))
                        texture[0] = i;
                });

                itemModelGenerator.register(
                    disc,
                    texture[0],
                    Models.GENERATED
                );
                return;
            }
            itemModelGenerator.register(disc, Models.GENERATED);
        });


    }
}
