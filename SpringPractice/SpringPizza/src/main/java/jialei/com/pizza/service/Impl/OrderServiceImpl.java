package jialei.com.pizza.service.Impl;

import jialei.com.pizza.domain.Order;
import jialei.com.pizza.service.OrderService;
import org.apache.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER =  Logger.getLogger(OrderServiceImpl.class);

    @Override
    public void saveOrder(Order order) {
        LOGGER.debug("SAVING ORDER:  " );
        LOGGER.debug("   Customer:  " + order.getCustomer().getName());
        LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
        LOGGER.debug("   Payment:  " + order.getPayment());
    }
}
