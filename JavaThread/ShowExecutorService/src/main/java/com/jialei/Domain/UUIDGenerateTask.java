package com.jialei.Domain;

import com.jialei.Common.UUIDContainer;

import java.util.*;

import static com.jialei.Common.UUIDContainer.PRESENT;


/**
 * Created by cdjialei on 2017/2/23.
 */
public class UUIDGenerateTask implements Runnable {
    private long count;
    private int taskID;
    public UUIDGenerateTask(long count, int taskID){
        this.count = count;
        this.taskID = taskID;
    }

    public void run() {
        System.out.println("Task run with ID: " + taskID);
        Map<UUID, Object> uuids = new HashMap<UUID, Object>();
        for (int i = 0; i < this.count; i++) {
            UUID uuit = UUID.randomUUID();
            uuids.put(uuit, PRESENT);
        }

        UUIDContainer.GetInstance().getUuidMap().putAll(uuids);
    }
}
