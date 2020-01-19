package com.jialei.myspringboot.demomq;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendAndReceiveMessage(){
        // 只需要传入要发送的对象，自动序列化发送给rabbitmq
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "this is the first msg");
        rabbitTemplate.convertAndSend("exchange.direct", "jialei.news", map);

        //直接将消息头转换为我们需要的对象
        Object object = rabbitTemplate.receiveAndConvert("jialei.news");
        Assert.assertTrue(object instanceof HashMap);
    }

}
