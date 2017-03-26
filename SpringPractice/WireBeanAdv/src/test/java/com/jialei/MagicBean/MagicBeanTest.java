package com.jialei.MagicBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by JiaLei on 2017/3/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MaginBeanConfig.class)
public class MagicBeanTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void MagicBeanExist(){
        assertTrue(context.containsBean("magicBean"));
    }
}
