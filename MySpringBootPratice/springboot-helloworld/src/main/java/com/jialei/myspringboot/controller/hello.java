/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jialei
 * @version : hello.java, v 0.1 2019年09月30日 16:33 jialei Exp $
 */
@Controller
public class hello {

    @RequestMapping("sucess")
    public String sucess(){
        return "sucess";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "hello";
    }

}