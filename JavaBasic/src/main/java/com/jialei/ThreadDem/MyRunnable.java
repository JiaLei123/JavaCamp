package com.jialei.ThreadDem;

public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Current_thread: " + Thread.currentThread().getName());
    }
}
