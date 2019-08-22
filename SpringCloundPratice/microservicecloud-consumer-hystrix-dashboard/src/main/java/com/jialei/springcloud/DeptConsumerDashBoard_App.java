package com.jialei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication()
@EnableHystrixDashboard
public class DeptConsumerDashBoard_App {
    public static void main( String[] args ) {
        SpringApplication.run(DeptConsumerDashBoard_App.class, args);
    }
}
