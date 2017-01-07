package com.java.jialei.Arithmetic;

import com.java.jialei.Interface.IArithmetic;

import java.util.Random;

/**
 * Created by JiaLei on 2016/9/10.
 */
public abstract class ArithmeticBase implements IArithmetic {

    public abstract void runArithmetic();

    public <T> void printList(T[] list){
        for (T a : list) {
            System.out.print(a.toString());
        }
    }
    public <T> void printList(String title, T[] list){
        System.out.println(title + ": ");
        int i = 0;
        for (T a : list) {
            if (i < list.length - 1) {
                System.out.print(a.toString() + ", ");
            } else {
                System.out.print(a.toString());
            }
            i++;
        }
        System.out.println();
    }

    public String[] GenerateStringList(){
        return new String[]{"4", "3", "1", "2"};
    }

    public Integer[] GenerateIntList(int length){
        Integer[] result = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(100);
        }
        return result;
    }
}
