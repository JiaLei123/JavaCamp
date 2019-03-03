package com.jialei;

import java.util.concurrent.CompletableFuture;

/**
 * Hello world!
 * the example for the artical 使用JAVA CompletableFuture的20例子
 */
public class BasicExample
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        completedFutureExample();
//        runAsyncExample();
//        thenApplyExample();
        thenApplyExample1();
    }

    /*
     * Returns a new CompletableFuture that is already completed with
     * the given value.
     */
    static void completedFutureExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }

    static void randomSleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleepEnough(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * Returns a new CompletableFuture that is asynchronously completed
     */
    static void runAsyncExample1() {
        CompletableFuture cf = CompletableFuture.runAsync(() -> {
            System.out.println("If it is a Demo process :" + Thread.currentThread().isDaemon());
            randomSleep();
        });

        System.out.println("Run finished " + cf.isDone());
        sleepEnough();
        System.out.println("Run finished " + cf.isDone());
    }


    /*
     * 将方法作用于前一个Stage
     */
    static void thenApplyExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            System.out.println("If it is a Demo process :" + Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });

        System.out.println("Result: " + cf.getNow(null));
    }


    /*
     * 将方法作用于前一个Stage
     */
    static void thenApplyExample1() {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("If it is a Demo process :" + Thread.currentThread().isDaemon());
            randomSleep();
            System.out.println(0.345/0);
            return "message";
        }).thenApply(s -> {
            System.out.println("If it is a Demo process :" + Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });

        System.out.println("Result: " + cf.join());
    }


}
