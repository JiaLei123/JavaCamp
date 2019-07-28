package jailei.com.aspectxml;

import java.util.List;

/**
 * Created by JiaLei on 2017/3/25.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }

    public void playTrack(int trackNumber) {
        System.out.println("Playing " + title + " by " + artist);
        String track = tracks.get(trackNumber);
        System.out.println("-Track: " + track);
    }
}
