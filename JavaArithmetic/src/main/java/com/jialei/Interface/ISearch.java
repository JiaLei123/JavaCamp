package com.java.jialei.Interface;

/**
 * Created by JiaLei on 2016/9/16.
 */
public interface ISearch {
    <T extends Comparable<T>> boolean find(T[] list, T key );
}
