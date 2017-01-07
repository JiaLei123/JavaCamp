package com.java.jialei;

import com.java.jialei.Interface.ISubject;

import java.lang.reflect.Field;

/**
 * Created by JiaLei on 2016/9/12.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Java Arithmetic Demo!");
        System.out.println("Begin Run");
        System.out.println("" + Constants.a);

        if(args.length < 1)
        {
            System.out.println("The Accept parameters are as below: ");

            Field[] fiels = System.class.getDeclaredFields();
            for (Field fi:
                 fiels) {
                System.out.print(fi.toString());
            }
        }

        Operation op = Operation.valueOf(args[0]);
        ISubject caller = SubjectCreater.Instance.Create(op);
        caller.NotifyObserver();
    }
}
