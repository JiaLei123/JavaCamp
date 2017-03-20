package com.jialei.XMLConfig.properties;

import com.jialei.XMLConfig.CompactDiscXMLConfig;
import com.jialei.XMLConfig.MediaPlayerXMLConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by JiaLei on 2017/3/15.
 */
public class CDPlayerXMLConfig implements MediaPlayerXMLConfig {
    public void setCd(CompactDiscXMLConfig cd) {
        this.cd = cd;
    }

    private CompactDiscXMLConfig cd;

//    @Autowired
//    public void setCompactDisc(CompactDiscXMLConfig compactDisc) {
//        this.cd = compactDisc;
//    }


    public void play() {
        cd.play();
    }
}
