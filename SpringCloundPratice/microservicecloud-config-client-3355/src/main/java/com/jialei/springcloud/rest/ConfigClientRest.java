package com.jialei.springcloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eruekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/config")
    public String list(){
        return String.format("ApplicationName: {%s}, EurekaServers: {%s}, Port={%s}", applicationName, eruekaServers, port);
    }
}
