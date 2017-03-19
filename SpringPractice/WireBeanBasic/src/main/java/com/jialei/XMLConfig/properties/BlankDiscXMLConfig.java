package com.jialei.XMLConfig.properties;

import com.jialei.XMLConfig.CompactDiscXMLConfig;

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
        System.out.println("Playing " + title + " by " + artist);
    }
}
