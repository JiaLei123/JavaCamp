package com.jialei.myspringboot.demomq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class MqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String exchange, String channel, Object body){
        // Mesasge需要自己构造，需要定义消息体和消息头
        //rabbitTemplate.send("", "", );

        // 只需要传入要发送的对象，自动序列化发送给rabbitmq
        rabbitTemplate.convertAndSend(exchange, channel, body);
    }

}
