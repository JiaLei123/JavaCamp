package com.jialei.myspringboot.aop;

import com.alibaba.fastjson.JSON;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author jialei
 * @version : ControllerAspect.java, v 0.1 2019年12月04日 12:08 下午 jialei Exp $
 */

@Component
@Aspect
public class ControllerAspect {

    Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("execution(* com.jialei.myspringboot.demowebview.controller.EmployeeController.*(..) )")
    public void controllerAspect() {
    }

    @Around(value="controllerAspect()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object obj=null;
        Object[] params = joinPoint.getArgs();
        logger.info("环绕前: " + JSON.toJSONString(params));
        try {
            obj=joinPoint.proceed(params);
        } catch (Throwable throwable) {
            logger.warn(JSON.toJSONString(throwable));
        }
        logger.info("环绕后" + JSON.toJSONString(obj));
        return obj;
    }
}