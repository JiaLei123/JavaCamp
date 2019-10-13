package com.jialei.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HelloController {

    @RequestMapping
    public String sucess(Model model){
        // classpath:/templates/sucess.html
        model.addAttribute("hello", "你好");
        model.addAttribute("users", Arrays.asList("a", "ab", "abc") );
        return "sucess";
    }
}
