package com.jialei.ThreadDem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        Consumer cm = new Consumer(queue, 2);
        Provider pd = new Provider(queue, 1);
        new Thread(cm).start();
        new Thread(pd).start();

    }
}

class Consumer implements Runnable {

    private BlockingQueue<String> queue;
    private int sleepTime;

    public Consumer(BlockingQueue<String> queue, int sleepTime){
        this.queue = queue;
        this.sleepTime = sleepTime;
    }

    public void run() {
        while (true){
            try{
                Thread.sleep(sleepTime * 1000);
                queue.put("DUMMY");
                System.out.println("PUT DUMMY");
            }catch (InterruptedException e){

            }
        }

    }
}

class Provider implements Runnable{
    private BlockingQueue<String> queue;
    private int sleepTime;
    public Provider(BlockingQueue<String> queue, int sleepTime){
        this.queue = queue;
        this.sleepTime = sleepTime;
    }

    public void run() {
        while (true){
            try{
                Thread.sleep(sleepTime * 1000);
                String dummy = queue.take();
                System.out.println("Take " +dummy);
            }catch (InterruptedException e){

            }
        }

    }
}
