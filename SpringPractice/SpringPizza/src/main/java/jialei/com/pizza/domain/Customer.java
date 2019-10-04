package jialei.com.pizza.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
}
