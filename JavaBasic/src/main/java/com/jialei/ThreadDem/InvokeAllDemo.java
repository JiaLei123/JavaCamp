package com.jialei.ThreadDem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<CallTask> tasks = new ArrayList<CallTask>();
        for (int i=0; i<100; i++){
            CallTask task = new CallTask();
            tasks.add(task);
        }

        System.out.println("主线程执行任务: " + Thread.currentThread().getName());

        try {
            int result = executor.invokeAny(tasks);
            System.out.println("InvokeAny 运行结果: " + result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            List<Future<Integer>> futureList = executor.invokeAll(tasks);

            for (Future<Integer> result: futureList){
                System.out.println("Invoke All 运行结果: " + result.get());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
