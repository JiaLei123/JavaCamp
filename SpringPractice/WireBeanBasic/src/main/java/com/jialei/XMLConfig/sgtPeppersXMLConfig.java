package com.jialei.XMLConfig;


/**
 * Created by JiaLei on 2017/3/18.
 */
public class sgtPeppersXMLConfig implements CompactDiscXMLConfig{
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println(String.format("playing %s by %s", title, artist));
    }
}
