package com.jialei.JavaConfig;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by JiaLei on 2017/3/15.
 */
public class CDPlayerJavaConfig implements MediaPlayerJavaConfig {
    private CompactDiscJavaConfig cd;

    @Autowired
    public CDPlayerJavaConfig(CompactDiscJavaConfig cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
