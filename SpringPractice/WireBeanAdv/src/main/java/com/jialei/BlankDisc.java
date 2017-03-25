package com.jialei;

import org.springframework.stereotype.Component;

/**
 * Created by JiaLei on 2017/3/25.
 */
public class BlankDisc implements CompactDisc {
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAritist(String aritist) {
        this.aritist = aritist;
    }

    private String title;
    private String aritist;

    public void play(){

    }
}
