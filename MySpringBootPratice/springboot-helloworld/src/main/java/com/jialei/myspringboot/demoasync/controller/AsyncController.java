package com.jialei.myspringboot.demoasync.controller;

import com.jialei.myspringboot.demoasync.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("query")
    @ResponseBody
    public String query() {
        return asyncService.hello();
    }

}
