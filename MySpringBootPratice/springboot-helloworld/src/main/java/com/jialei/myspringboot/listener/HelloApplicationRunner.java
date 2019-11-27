package com.jialei.myspringboot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author jialei
 * @version : HelloApplicatoinRunner.java, v 0.1 2019年11月27日 11:38 上午 jialei Exp $
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("HelloApplicationRunner... run");
    }
}