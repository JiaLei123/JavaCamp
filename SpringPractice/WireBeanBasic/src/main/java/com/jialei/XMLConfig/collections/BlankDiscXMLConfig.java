package com.jialei.XMLConfig.collections;

import com.jialei.XMLConfig.CompactDiscXMLConfig;

import java.util.List;

/**
 * Created by JiaLei on 2017/3/19.
 */
public class BlankDiscXMLConfig implements CompactDiscXMLConfig {
    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDiscXMLConfig(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }
}
