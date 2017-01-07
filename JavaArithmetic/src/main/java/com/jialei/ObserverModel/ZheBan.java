package com.java.jialei.ObserverModel;

import com.java.jialei.Arithmetic.ArithmeticBase;
import com.java.jialei.Arithmetic.BinarySearch;
import com.java.jialei.Interface.IObserver;
import com.java.jialei.Interface.ISearch;

import java.util.Random;

/**
 * Created by JiaLei on 2016/9/16.
 */
public class ZheBan extends ArithmeticBase implements IObserver {
    @Override
    public void runArithmetic() {
        Integer[] slist = GenerateIntList(40);
        //print orignal list
        printList("ZheBan Sort List", slist);

        Random random = new Random();
        int key = random.nextInt(100);

        ISearch search = new BinarySearch();
        boolean isFind = search.find(slist, key);

        System.out.println("ZheBan Search Key: "+ key + " with result: " + isFind);
    }

    @Override
    public void Update() {
        this.runArithmetic();
    }
}
