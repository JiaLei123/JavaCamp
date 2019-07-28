package jailei.com.aspectxml;

import jailei.com.aspectbasic.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:audience_config.xml")
public class AudienceTest {

    @Autowired
    private Performance myperformance;

    @Test
    public void testRunPerformance(){
        myperformance.perform();
    }

}
