package com.jialei.selfDefineQualifier;

import com.jialei.selfDefineQualifier.Annotation.Cold;
import com.jialei.selfDefineQualifier.Annotation.Milk;
import com.jialei.selfDefineQualifier.Annotation.Tea;
import org.springframework.stereotype.Component;

/**
 * Created by cdjialei on 2017/3/27.
 */
@Component
@Cold
@Tea
public class IceBlackTea implements Dessert {
    private int cal;
    public void eat(){
        cal = 0;
    }
}
