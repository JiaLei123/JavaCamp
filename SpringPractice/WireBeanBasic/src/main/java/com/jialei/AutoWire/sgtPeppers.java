package com.jialei.AutoWire;

import org.springframework.stereotype.Component;

/**
 * Created by JiaLei on 2017/3/15.
 */

@Component
public class sgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println(String.format("playing %s by %s", title, artist));
    }
}
