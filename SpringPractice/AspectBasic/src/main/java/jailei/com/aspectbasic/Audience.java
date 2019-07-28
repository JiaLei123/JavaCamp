package jailei.com.aspectbasic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(* jailei.com.aspectbasic.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("silence Cell Phones");
    }

    @After("performance()")
    public void afterPlay(){
        System.out.println("Play Done");
    }

    @AfterReturning("performance()")
    public void afterGoHome(){
        System.out.println("Go Home");
    }

    @Around("performance()")
    public void doBeforeAndAfter(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Count before");
        jp.proceed();
        System.out.println("Count After");
    }
}
