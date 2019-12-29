package jialei.com.spitter.demonosqldb.web;

import com.alibaba.fastjson.JSON;
import jialei.com.spitter.demodataaccess.domain.SpittleDomain;
import jialei.com.spitter.demonosqldb.model.Item;
import jialei.com.spitter.demonosqldb.model.Order;
import jialei.com.spitter.demonosqldb.repository.OrderRepositoryBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("nosql")
public class NoSqlDBController {

    @Autowired
    private OrderRepositoryBase orderRepositoryBase;

    @RequestMapping("saveOrder")
    public String saveOrder(@PathVariable("id") long id){
        Order order = createAnOrder();
        orderRepositoryBase.saveOrder(order);
        return "true";
    }

    @RequestMapping("countOrder")
    public String countOrder(){
        return orderRepositoryBase.getCount().toString();
    }

    @RequestMapping("findOrder/{id}")
    public String findOrder(@PathVariable("id") long id){
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
