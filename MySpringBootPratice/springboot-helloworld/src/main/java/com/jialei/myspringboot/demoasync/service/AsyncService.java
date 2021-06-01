package com.jialei.myspringboot.demoasync.service;

import com.jialei.myspringboot.MyspringbootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    private Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public String hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("数据处理中.....");
        return "success";
    }
}
