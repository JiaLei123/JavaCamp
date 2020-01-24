package jailei.com.aspectxml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cd_config.xml")
public class TrackCounterTest {
    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testRunPlay(){
        compactDisc.playTrack(1);
        compactDisc.playTrack(1);
        compactDisc.playTrack(2);
        compactDisc.playTrack(2);
        compactDisc.playTrack(3);
        compactDisc.playTrack(4);
        compactDisc.playTrack(5);
        compactDisc.playTrack(5);

        assertEquals(3, trackCounter.getPlayCounter(1));
        assertEquals(2, trackCounter.getPlayCounter(2));
        assertEquals(1, trackCounter.getPlayCounter(3));
        assertEquals(1, trackCounter.getPlayCounter(4));
        assertEquals(2, trackCounter.getPlayCounter(5));

    }

}
