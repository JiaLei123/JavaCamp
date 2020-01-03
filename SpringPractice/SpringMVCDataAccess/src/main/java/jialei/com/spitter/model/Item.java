package jialei.com.spitter.model;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private Order order;
    private String product;
    private double price;
    private int quantity;
}