package jailei.com.aspectxml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

public class Audience {
    public void silenceCellPhones(){
        System.out.println("silence Cell Phones");
    }

    public void afterPlay(){
        System.out.println("Play Done");
    }

    public void afterGoHome(){
        System.out.println("Go Home");
    }

    public void doBeforeAndAfter(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Count before");
        jp.proceed();
        System.out.println("Count After");
    }
}
