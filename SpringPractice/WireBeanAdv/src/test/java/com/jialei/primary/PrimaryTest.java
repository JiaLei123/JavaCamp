package com.jialei.primary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by cdjialei on 2017/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DesertConfig.class)
public class PrimaryTest {
    @Autowired
    private Dessert dessert;

    @Test
    public void wireTest(){
        assertNotNull(dessert);
    }
}
