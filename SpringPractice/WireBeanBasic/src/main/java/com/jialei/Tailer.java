package com.jialei;

import org.springframework.stereotype.Component;

/**
 * Created by JiaLei on 2017/3/15.
 */
public class Tailer implements CompactDisc {
    private String title = "Faded";
    private String artist = "Alon walker";

    public void play() {
        System.out.println(String.format("playing %s by %s", title, artist));
    }
}
