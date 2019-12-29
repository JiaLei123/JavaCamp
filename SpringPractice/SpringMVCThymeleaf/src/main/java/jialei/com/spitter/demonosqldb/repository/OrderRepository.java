package jialei.com.spitter.demonosqldb.repository;

import jialei.com.spitter.demonosqldb.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomer(String c);
}
