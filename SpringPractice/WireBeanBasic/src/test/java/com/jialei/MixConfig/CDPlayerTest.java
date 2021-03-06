package com.jialei.MixConfig;

import com.jialei.MixConfig.javaBean.MixConfiguration;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by JiaLei on 2017/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MixConfiguration.class)
public class CDPlayerTest {
    @Autowired(required = false)
    private CompactDiscMixConfig cd;

    @Autowired
    private MediaPlayerMixConfig player;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        assertEquals("playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n", log.getLog());
    }
}
