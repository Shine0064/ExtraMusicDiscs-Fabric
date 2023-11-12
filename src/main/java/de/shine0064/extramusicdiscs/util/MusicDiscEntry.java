package de.shine0064.extramusicdiscs.util;

public class MusicDiscEntry {
    public final String name;
    public final String artist;
    public final String title;
    public final String textureOverride;
    public final int lengthInSeconds;
    public final int compOutput;

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
