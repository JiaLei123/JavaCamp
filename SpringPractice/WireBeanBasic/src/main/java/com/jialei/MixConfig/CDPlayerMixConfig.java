package com.jialei.MixConfig;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by JiaLei on 2017/3/15.
 */
public class CDPlayerMixConfig implements MediaPlayerMixConfig {
    private CompactDiscMixConfig cd;

    @Autowired
    public CDPlayerMixConfig(CompactDiscMixConfig cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
