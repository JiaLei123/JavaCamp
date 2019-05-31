package com.jialei.ThreadDem;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDem {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CallTask task = new CallTask();
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        for (int i=0; i<100; i++){
            Future<Integer> result = executor.submit(task);
            futureList.add(result);
        }

        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行任务: " + Thread.currentThread().getName());

        try {
            for (Future<Integer> result: futureList){
                System.out.println("运行结果: " + result.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class CallTask implements Callable<Integer>{

    public Integer call() throws Exception {
        System.out.println("Thread Calculate: " + Thread.currentThread().getName());
        Thread.sleep(2000);
        int sum = 0;
        for(int i=0; i<100; i++){
            sum +=1;
        }
        return sum;
    }
}