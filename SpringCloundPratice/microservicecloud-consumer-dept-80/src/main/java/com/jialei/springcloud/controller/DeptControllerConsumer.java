package com.jialei.springcloud.controller;

import com.jialei.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptControllerConsumer {
//    private final String REST_URL_PREFIX = "http://localhost:8001";
    private final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept getDept = restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        return getDept;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

//    @RequestMapping(value = "consumer/discovery")
//    public Object discovery(){
//        return discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
//    }
}
