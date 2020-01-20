package com.jialei.myspringboot.demomq.service;

import com.alibaba.fastjson.JSON;
import com.jialei.myspringboot.demoreadconfig.bean.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private Logger logger = LoggerFactory.getLogger(MqService.class);

    public void sendMessage(String exchange, String channel, Object body){
        // Mesasge需要自己构造，需要定义消息体和消息头
        //rabbitTemplate.send("", "", );

        // 只需要传入要发送的对象，自动序列化发送给rabbitmq
        rabbitTemplate.convertAndSend(exchange, channel, body);
    }

    @RabbitListener(queues = "jialei.news")
    public void receive1(Person person){
        logger.info("Rabbit Queue[jialei.news] Receive" + JSON.toJSONString(person));
    }

    @RabbitListener(queues = "lina.news")
    public void receive2(Person person){
        logger.info("Rabbit Queue[lina.news] Receive" + JSON.toJSONString(person));
    }
}
