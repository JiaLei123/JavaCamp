package com.jialei.myspringboot.demomq.controller;

import com.jialei.myspringboot.demomq.service.MqService;
import com.jialei.myspringboot.demoreadconfig.bean.Person;
import com.jialei.myspringboot.model.User;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mq")
public class MqController {
    @Autowired
    private MqService mqService;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private Person person;

    @RequestMapping("sendToNews")
    @ResponseBody
    public String sendToNews(){
        mqService.sendMessage("exchange.topic", "jialei.#", person);
        return "success";
    }


    public String createMqEnv(){
        // 创建 Exchange
        amqpAdmin.declareExchange(new DirectExchange("exchange.test"));
        // 创建 Queue
        amqpAdmin.declareQueue(new Queue("queue.test"));
        // 创建Binding
        amqpAdmin.declareBinding(new Binding("queue.test", Binding.DestinationType.QUEUE, "exchange.test", "queue.test", null));

        return "";
    }

}
