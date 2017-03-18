package com.jialei.JavaConfig;

import com.jialei.CompactDisc;
import com.jialei.JavaConfig.javaBean.*;
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
 * Created by JiaLei on 2017/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfigJavaConfig.class)
public class CDPlayerJavaConifgTest {
    @Autowired
    private MediaPlayerJavaConfig player;

    @Autowired(required = false)
    private CompactDiscJavaConfig cd;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

    @Test
    public void player(){
        player.play();
        assertEquals("playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n", log.getLog());
    }

}
