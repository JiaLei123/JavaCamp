package com.jialei.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by cdjialei on 2017/3/27.
 */
@Component
public class IceCream implements Dessert {
    private int cal;
    public void eat(){
        cal = 0;
    }
}
