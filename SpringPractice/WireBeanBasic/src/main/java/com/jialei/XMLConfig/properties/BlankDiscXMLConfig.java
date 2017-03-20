package com.jialei.XMLConfig.properties;

import com.jialei.XMLConfig.CompactDiscXMLConfig;

import java.util.List;

/**
 * Created by JiaLei on 2017/3/19.
 */
public class BlankDiscXMLConfig implements CompactDiscXMLConfig {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    private String title;
    private String artist;
    private List<String> tracks;


    public void play() {
        System.out.println("playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }
}
