package com.jialei.myspringboot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author jialei
 * @version : HelloCommandLineRunner.java, v 0.1 2019年11月27日 11:39 上午 jialei Exp $
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("HelloCommandLineRunner... run");
    }
}