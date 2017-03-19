package com.jialei.XMLConfig;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by JiaLei on 2017/3/15.
 */
public class CDPlayerXMLConfig implements MediaPlayerXMLConfig {
    private CompactDiscXMLConfig cd;

    @Autowired
    public CDPlayerXMLConfig(CompactDiscXMLConfig cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
