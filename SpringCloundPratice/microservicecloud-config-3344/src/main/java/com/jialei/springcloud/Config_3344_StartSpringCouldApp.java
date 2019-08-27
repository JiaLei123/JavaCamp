package com.jialei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
//@EnableDiscoveryClient
public class Config_3344_StartSpringCouldApp {
    public static void main( String[] args ) {
        SpringApplication.run(Config_3344_StartSpringCouldApp.class, args);
    }
}
