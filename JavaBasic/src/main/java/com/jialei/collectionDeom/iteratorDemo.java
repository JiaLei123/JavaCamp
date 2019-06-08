package com.jialei.collectionDeom;

import java.util.*;

public class iteratorDemo {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        for(int i=0; i <100; i++){
            list.add("MAIN");
        }

//        for(String item : list){
//            System.out.println(item);
//            Runnable mr = new AddElementTask(list);
//            Thread t = new Thread(mr);
//            t.start();
//        }

        ListIterator<String> itr = list.listIterator();
        ListIterator<String> itrWrite = list.listIterator();
        while (itr.hasNext()){
            String item = itr.next();
            itrWrite.next();
            System.out.println(item);
            Runnable mr = new AddIterator(itrWrite);
            Thread t = new Thread(mr);
            t.start();
        }


    }
}

class AddIterator implements Runnable {
    private ListIterator<String> itr;

    public AddIterator(ListIterator<String> itr){
        this.itr = itr;
    }

    public void run() {
        itr.add("Runnable");
        System.out.println("Current_thread: " + Thread.currentThread().getName());
    }
}

class AddElementTask implements Runnable {
    private List<String> list;

    public AddElementTask(List<String> list){
        this.list = list;
    }

    public void run() {
        list.add("Runnable");
        String[] listArray = list.toArray(new String[0]);
        System.out.println("Current_thread: " + Thread.currentThread().getName());
    }
}
