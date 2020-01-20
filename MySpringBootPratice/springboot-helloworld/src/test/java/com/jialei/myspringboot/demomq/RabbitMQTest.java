package com.jialei.myspringboot.demomq;


import com.jialei.myspringboot.demoreadconfig.bean.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Person person;

    @Before
    public void cleanQueue(){
        cleanQueue("jialei");
        cleanQueue("jialei.emps");
        cleanQueue("jialei.news");
        cleanQueue("lina.news");
    }

    private void cleanQueue(String queueName){
        Object object = null;
        do{
            object = rabbitTemplate.receiveAndConvert(queueName);
        }while (object != null);
    }

    @Test
    public void sendMessage(){
        // 只需要传入要发送的对象，自动序列化发送给rabbitmq
        rabbitTemplate.convertAndSend("exchange.direct", "jialei.news", person);

    }

    @Test
    public void receiveMessage(){
        Object object = rabbitTemplate.receiveAndConvert("jialei.emps");
        Assert.assertNull(object);
    }

    @Test
    public void sendFinOutsMessageLoop(){
        int n = 100000;
        while (n > 1){
            sendFinOutsMessage();
            n--;
        }
    }
    
    @Test
    public void sendFinOutsMessage(){
        // 只需要传入要发送的对象，自动序列化发送给rabbitmq
        rabbitTemplate.convertAndSend("exchange.fanout", "s", person);

        //直接将消息头转换为我们需要的对象
        Object object = rabbitTemplate.receiveAndConvert("jialei");
        Assert.assertTrue(object instanceof Person);

        Object object1 = rabbitTemplate.receiveAndConvert("jialei.news");
        Assert.assertTrue(object1 instanceof Person);

        Object object2 = rabbitTemplate.receiveAndConvert("jialei.emps");
        Assert.assertTrue(object2 instanceof Person);

        Object object3 = rabbitTemplate.receiveAndConvert("lina.news");
        Assert.assertTrue(object3 instanceof Person);
    }
    
    

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
