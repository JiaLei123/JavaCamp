package com.java.jialei.Interface;

import java.util.Comparator;

public interface ISorter {
   /**
    * @throws
    * @param list array list
    * @param <T> the type of the array
    */
   public <T extends Comparable<T>> void sort(T[] list);

   public <T> void sort(T[] list, Comparator<T> comp);
}