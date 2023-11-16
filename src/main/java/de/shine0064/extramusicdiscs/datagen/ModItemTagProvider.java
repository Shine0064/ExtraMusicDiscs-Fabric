package de.shine0064.extramusicdiscs.datagen;

import de.shine0064.extramusicdiscs.util.ModTags;
import de.shine0064.extramusicdiscs.util.MusicDiscs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        MusicDiscs.MUSIC_DISCS.forEach((disc) -> {
            getOrCreateTagBuilder(ModTags.Items.MUSIC_DISCS)
                .add(disc)
            ;

            getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(disc)
            ;

            getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(disc)
            ;
        });
    }
}
