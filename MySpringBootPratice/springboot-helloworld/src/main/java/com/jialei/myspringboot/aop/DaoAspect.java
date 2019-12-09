/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.myspringboot.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 *
 * @author jialei
 * @version : DaoAspect.java, v 0.1 2019年12月04日 2:36 下午 jialei Exp $
 */
@EnableAspectJAutoProxy
@Configuration
@Component
@Aspect
public class DaoAspect {
    @Pointcut("execution(* com.jialei.myspringboot.dao.RoleDao.*(..) )")
    public void controllerAspect() {
    }

    @Around(value="controllerAspect()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object obj=null;
        Object[] params = joinPoint.getArgs();
        System.out.println("环绕前: " + JSON.toJSONString(params));
        try {
            obj=joinPoint.proceed(params);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后" + JSON.toJSONString(obj));
        return obj;
    }
}