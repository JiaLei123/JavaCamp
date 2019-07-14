package com.jialei.propertyBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

public class EnvironmentConfigWithRequriedTest {
    @Autowired
    private BlankDisc blankDisc;

    @Test(expected=BeanCreationException.class)
    public void assertBlankDiscProperties() {
        new AnnotationConfigApplicationContext(EnvironmentConfigWithRequiredProperties.class);
    }
}
