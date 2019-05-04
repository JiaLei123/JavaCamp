package com.jialei.ThrowDemo;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;


@Slf4j
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for(StackTraceElement frame : frames){
            log.info(frame.toString());
        }
    }
}
