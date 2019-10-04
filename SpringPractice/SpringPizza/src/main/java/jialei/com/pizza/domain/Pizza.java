package jialei.com.pizza.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Pizza implements Serializable {
    private PizzaSize size;
    private List<Topping> toppings;

    public void setSize(String sizeString) {
        this.size = PizzaSize.valueOf(sizeString);
    }

    public void setToppings(String[] toppingStrings) {
        for (int i = 0; i < toppingStrings.length; i++) {
            toppings.add(Topping.valueOf(toppingStrings[i]));
        }
    }
}
