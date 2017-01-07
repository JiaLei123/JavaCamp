package com.java.jialei.Arithmetic;

import com.java.jialei.Interface.ISorter;

import java.util.Comparator;

public class BubbleISorter implements ISorter {

    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for(int i = 1; i < list.length && swapped; i++) {
            swapped = false;
            for(int j = 0; j < list.length - i; j++) {
                if(list[j].compareTo(list[j+1]) > 0) {
                    T temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                    swapped = true;
                }
            }
        }
    }

    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for(int i = 1; i < list.length && swapped; i ++) {
            swapped = false;
            for(int j = 0; j < list.length -i; j++) {
                if(comp.compare(list[j], list[j=1]) > 0) {
                    T temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                    swapped = true;
                }
            }
        }
    }
}