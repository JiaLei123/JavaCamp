package com.jialei.myspringboot.demoautoconfig.controller;

import com.jialei.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jialei
 * @version : AutoConfigController.java, v 0.1 2019年12月02日 10:45 上午 jialei Exp $
 */
@RestController
@RequestMapping("auto")
public class AutoConfigController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("run")
    public String run(){
        return helloService.runService();
    }

}