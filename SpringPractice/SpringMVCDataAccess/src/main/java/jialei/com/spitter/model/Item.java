package jialei.com.spitter.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {
    private Long id;
    private Order order;
    private String product;
    private double price;
    private int quantity;
}
