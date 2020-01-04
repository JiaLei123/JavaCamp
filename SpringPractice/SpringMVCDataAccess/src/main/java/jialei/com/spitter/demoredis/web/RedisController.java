package jialei.com.spitter.demoredis.web;

import com.alibaba.fastjson.JSON;
import jialei.com.spitter.model.Item;
import jialei.com.spitter.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Random;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Order> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("setValue")
    public String saveOrder(){
        Order order = createAnOrder();
        redisTemplate.opsForValue().set(order.getId(), order);
        return order.getId();
    }

    @RequestMapping("getValue")
    public String queryOrder(@RequestParam("id") String id){
        Order order = redisTemplate.opsForValue().get(id);
        return JSON.toJSONString(order);
    }

    @RequestMapping("setList")
    public String saveOrderList(){
        Order order = createAnOrder();
        redisTemplate.opsForList().rightPush("order", order);
        return order.getId();
    }

    @RequestMapping("getList")
    public String queryOrderList(){
        Order order = redisTemplate.opsForList().leftPop("order");
        return JSON.toJSONString(order);
    }

    private Order createAnOrder() {
        Order order = new Order();
        order.setCustomer("Chuck Wagon");
        order.setType("WEB");
        Item item1 = new Item();
        item1.setProduct("Spring in Action");
        item1.setQuantity(2);
        item1.setPrice(29.99);
        Item item2 = new Item();
        item2.setProduct("Module Java");
        item2.setQuantity(31);
        item2.setPrice(29.95);
        order.setItems(Arrays.asList(item1, item2));
        order.setId(String.valueOf(new Random().nextLong()));
        return order;
    }

}
