package jialei.com.spitter.demomongo.web;

import com.alibaba.fastjson.JSON;
import jialei.com.spitter.model.Item;
import jialei.com.spitter.model.Order;
import jialei.com.spitter.demomongo.repository.OrderRepository;
import jialei.com.spitter.demomongo.repository.OrderRepositoryBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("nosql")
public class NoSqlDBController {

    @Autowired
    private OrderRepositoryBase orderRepositoryBase;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("saveOrder")
    public String saveOrder(){
        Order order = createAnOrder();
        orderRepositoryBase.saveOrder(order);
        return "true";
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("countOrder")
    public String countOrder(){
        return String.valueOf(orderRepository.count());
    }

    @RequestMapping("countOrder1")
    public String countOrder1(){
        return orderRepositoryBase.getCount().toString();
    }

    @RequestMapping("findOrders")
    public String findOrder(){
        List<Order> orders = orderRepository.findAll();
        return JSON.toJSONString(orders);
    }

    @RequestMapping("findOrder1/{id}")
    public String findOrder1(@PathVariable("id") String id){
        Order order = orderRepositoryBase.findById(id);
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
        return order;
    }
}
