package com.jialei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class DeptConsumer80_App {
    public static void main( String[] args ) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
