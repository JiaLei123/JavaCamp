package com.jialei.Tools;

import com.jialei.Domain.UUIDGenerateTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cdjialei on 2017/2/23.
 */
public class VarifyUUID {
    public void generateUUID(long count){
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        long threadcount = count / 1000;

        for (int i = 0; i < threadcount; i++) {
            UUIDGenerateTask task = new UUIDGenerateTask(1000, i);
            executorService.execute(task);
        }
        executorService.shutdown();

        while(true){
            if(executorService.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                break;
            }
            try {
                Thread.sleep(1000);
            }catch (Exception e) {

            }

        }

    }
}

