package com.jialei.MagicBean;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by JiaLei on 2017/3/26.
 */
public class MagicBeanConditon implements Condition{
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
        Environment env =  context.getEnvironment();
        String tomcateHome = env.getProperty("CATALINA_HOME");
        if(tomcateHome.contentEquals( "C:\\JavaTools\\apache-tomcat-8.5.6")){
            return true;
        }else {
            return false;
        }
    }
}
