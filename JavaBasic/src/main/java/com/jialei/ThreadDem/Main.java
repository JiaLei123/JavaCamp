package com.jialei.ThreadDem;

public class Main {

    public static void main(String[] args) {
        for(int i=0; i <100; i++){
            Runnable mr = new MyRunnable();
            Thread t = new Thread(mr);
            t.start();
        }

    }
}
