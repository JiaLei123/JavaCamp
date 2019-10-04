package jialei.com.pizza.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order implements Serializable {
    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;

    public Order() {
        pizzas = new ArrayList<Pizza>();
        customer = new Customer();
    }

    public void addPizza(Pizza pizza) {
        System.out.println(pizza.toString());
        pizzas.add(pizza);
    }

    public float getTotal() {
        return 0.0f;//pricingEngine.calculateOrderTotal(this);
    }
}
