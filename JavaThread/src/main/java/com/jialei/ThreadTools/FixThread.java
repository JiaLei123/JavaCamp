package com.jialei.ThreadTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cdjialei on 2017/2/22.
 */
public class FixThread {
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }
}
