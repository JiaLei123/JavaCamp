package com.java.jialei.Arithmetic;

import com.java.jialei.Interface.ISearch;

/**
 * Created by JiaLei on 2016/9/16.
 */
public class BinarySearch implements ISearch {
    @Override
    public <T extends Comparable<T>> boolean find(T[] list, T key) {
        //the bainary search need the sord list
        BubbleISorter sorter = new BubbleISorter();
        sorter.sort(list);

        int low = 0;
        int high = list.length - 1;
        while (low < high) {
            int middel = low + (high - low) / 2;
            int cmp = list[middel].compareTo(key);
            if ( cmp< 0) {
                low = middel + 1;
            } else if (cmp > 0) {
                high = middel - 1;
            } else {
                return true;
            }
        }
        //can't find key
        return false;
    }
}
