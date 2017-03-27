package com.jialei.selfDefineQualifier;

import com.jialei.selfDefineQualifier.Annotation.Hot;
import org.springframework.stereotype.Component;

/**
 * Created by cdjialei on 2017/3/27.
 */
@Component
@Hot
public class ButterCookies implements Dessert {
    private int cal;
    public void eat(){
        cal = 0;
    }
}
