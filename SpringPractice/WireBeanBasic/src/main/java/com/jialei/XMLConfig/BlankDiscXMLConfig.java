package com.jialei.XMLConfig;

/**
 * Created by JiaLei on 2017/3/19.
 */
public class BlankDiscXMLConfig implements CompactDiscXMLConfig {
    private String title;
    private String artist;

    public BlankDiscXMLConfig(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.println("playing " + title + " by " + artist);
    }
}
