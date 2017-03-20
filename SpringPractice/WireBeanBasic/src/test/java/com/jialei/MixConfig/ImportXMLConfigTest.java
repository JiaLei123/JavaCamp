package com.jialei.MixConfig;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by cdjialei on 2017/3/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cdPlayer_config.xml")
public class ImportXMLConfigTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayerMixConfig player;


    @Test
    public void play() {
        player.play();
        assertEquals(
                "playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n",
                log.getLog());
    }
}
