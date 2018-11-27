package com.jialei.scopebean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by JiaLei on 2018/11/27.
 */
public class ScopedBeanTests {
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=ComponentScannedConfig.class)
    public static class ComponentScannedScopeBeanTest{

        @Autowired
        private ApplicationContext context;

        @Test
        public void testProxyScope(){
            NotePad notePad1 = context.getBean(NotePad.class);
            NotePad notePad2 = context.getBean(NotePad.class);
            assertNotSame(notePad1, notePad2);
        }

        @Test
        public void testSingletonScope(){
            UniqueThing thing1 = context.getBean(UniqueThing.class);
            UniqueThing thing2 = context.getBean(UniqueThing.class);
            assertSame(thing1, thing2);
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=ExplicitConfig.class)
    public static class ExplicitConfigScopedBeanTest {
        @Autowired
        private ApplicationContext context;

        @Test
        public void testProxyScope(){
            NotePad notePad1 = context.getBean(NotePad.class);
            NotePad notePad2 = context.getBean(NotePad.class);
            assertNotSame(notePad1, notePad2);
        }

        @Test
        public void testSingletonScope(){
            UniqueThing thing1 = context.getBean(UniqueThing.class);
            UniqueThing thing2 = context.getBean(UniqueThing.class);
            assertSame(thing1, thing2);
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:scoped-beans.xml")
    public static class XMLConfigScopedBeanTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void testProxyScope() {
            NotePad notepad1 = context.getBean(NotePad.class);
            NotePad notepad2 = context.getBean(NotePad.class);
            assertNotSame(notepad1, notepad2);
        }

        @Test
        public void testSingletonScope() {
            UniqueThing thing1 = context.getBean(UniqueThing.class);
            UniqueThing thing2 = context.getBean(UniqueThing.class);
            assertSame(thing1, thing2);
        }

    }
}
