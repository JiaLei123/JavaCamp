package com.jialei.selfDefineQualifier;

import com.jialei.selfDefineQualifier.Annotation.Cold;
import com.jialei.selfDefineQualifier.Annotation.Milk;
import org.springframework.stereotype.Component;

/**
 * Created by cdjialei on 2017/3/27.
 */
@Component
@Cold
@Milk
public class IceCream implements Dessert {
    private int cal;
    public void eat(){
        cal = 0;
    }
}
