package jailei.com.aspectxml;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {
    private Map<Integer, Integer> trackCounters = new HashMap<>();

    public void countTrack(int trackNumber){
        int currentCount = trackCounters.getOrDefault(trackNumber, 0);
        trackCounters.put(trackNumber, currentCount + 1);
    }

    public int getPlayCounter(int trackNumber){
        return trackCounters.containsKey(trackNumber)? trackCounters.get(trackNumber): 0;

    }
}
