package com.jialei.myspringboot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author jialei
 * @version : HelloApplicationContextInitializer.java, v 0.1 2019年11月27日 11:19 上午 jialei Exp $
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer... initialize");
    }
}