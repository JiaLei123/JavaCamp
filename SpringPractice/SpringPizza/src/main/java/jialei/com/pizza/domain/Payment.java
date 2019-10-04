package jialei.com.pizza.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Payment implements Serializable {
    private float amount;
}
