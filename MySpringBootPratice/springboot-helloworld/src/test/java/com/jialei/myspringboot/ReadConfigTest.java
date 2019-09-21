/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.myspringboot;

import com.jialei.myspringboot.bean.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author jialei
 * @version : ReadConfigTest.java, v 0.1 2019年09月19日 10:37 jialei Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadConfigTest {
    @Autowired
    private Person person;

    @Autowired
    private PersonDev personDev;

    @Autowired
    private PersonValue personValue;

    //@Autowired
    //private PersonValid personValid;

    @Autowired
    private PersonOutSide personOutSide;

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void testPerson(){
        System.out.println(person);
        Assert.assertEquals(person.getLastName(), "testName");
    }

    @Test
    public void testPersonBlock(){
        System.out.println(person);
        Assert.assertEquals((int)person.getAge(), 15);
    }

    @Test
    public void testPersonDev(){
        System.out.println(personDev);
        Assert.assertEquals(personDev.getLastName(), "testName dev");
    }
    @Test
    public void testPersonValue(){
        System.out.println(personValue);
        Assert.assertEquals(personValue.getLastName(), "testName");
        Assert.assertEquals((long)personValue.getAge(), 11 * 12);
    }

    //@Test
    //public void testPersonValid(){
    //    System.out.println(personValid);
    //    Assert.assertEquals(personValid.getLastName(), "testName");
    //}

    @Test
    public void testPersonOutSide(){
        System.out.println(personOutSide);
        Assert.assertEquals(personOutSide.getLastName(), "test-properties");
    }

    @Test
    public void testBean(){
        Assert.assertTrue(ioc.containsBean("person"));
        Assert.assertTrue(ioc.containsBean("getPerson"));
    }
}