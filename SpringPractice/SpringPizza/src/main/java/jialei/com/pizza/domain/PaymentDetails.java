package jialei.com.pizza.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentDetails implements Serializable {
    private PaymentType paymentType;
    private String creditCardNumber;
}
