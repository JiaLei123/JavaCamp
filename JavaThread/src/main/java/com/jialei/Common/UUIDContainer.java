package com.jialei.Common;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cdjialei on 2017/2/23.
 */
public class UUIDContainer {

    public static final Object PRESENT = new Object();
    private static UUIDContainer Instance;
    private ConcurrentHashMap<UUID, Object> uuidMap = null;

    private UUIDContainer() {
        uuidMap = new ConcurrentHashMap<UUID, Object>();
    }

    public static synchronized UUIDContainer GetInstance(){
        if(Instance == null){
            Instance = new UUIDContainer();
        }
        return Instance;
    }

    public synchronized ConcurrentHashMap<UUID, Object> getUuidMap(){
        return uuidMap;
    }

    public synchronized void Clean(){
        this.uuidMap.clear();
    }
}
