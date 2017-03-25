package com.jialei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by JiaLei on 2017/3/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CompactDiscConfig.class)
@ActiveProfiles("Test")
public class TestProfileTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void TestCD(){
        assertTrue(cd instanceof StgDisc);
    }

}
