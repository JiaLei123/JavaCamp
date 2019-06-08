package com.jialei.collectionDeom;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class treeSetDemo {
    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<String>();
        set.add("A");
        set.add("B");
        set.add("A");

        set.forEach(a -> {
            System.out.println(a);
        });
    }
}
