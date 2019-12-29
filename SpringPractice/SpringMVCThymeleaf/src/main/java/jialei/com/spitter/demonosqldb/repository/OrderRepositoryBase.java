package jialei.com.spitter.demonosqldb.repository;

import jialei.com.spitter.demonosqldb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryBase {
    @Autowired
    private MongoOperations mongoOperations;

    public Long getCount(){
        return mongoOperations.getCollection("order").count();
    }

    public void saveOrder(Order order){
        mongoOperations.save(order, "order");
    }

    public Order findById(Long orderId){
        return mongoOperations.findById(orderId, Order.class);
    }

    public List<Order> findByClient(String clientName){
        return mongoOperations.find(Query.query(Criteria.where("client").is(clientName)), Order.class);
    }

}
