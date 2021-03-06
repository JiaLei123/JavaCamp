package com.jialei.XMLConfig;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * Created by JiaLei on 2017/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class ConstructorArgRefTest {

    @Autowired
    private MediaPlayerXMLConfig player;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void play(){
        player.play();
        assertEquals(
                "playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n",
                log.getLog());
    }
}
