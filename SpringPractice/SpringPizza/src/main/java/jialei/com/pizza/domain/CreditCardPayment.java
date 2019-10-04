package jialei.com.pizza.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreditCardPayment extends Payment {
    private String authorization;
}
