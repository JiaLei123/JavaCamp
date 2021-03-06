package com.jialei.ThreadDem.UnSyncDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        for(int i=0; i<accounts.length; i++){
            accounts[i] = initialBalance;
        }
    }

//  public synchronized void transfer(int from, int to, double amount){
    public synchronized void transfer(int from, int to, double amount){
//        bankLock.lock();
        try{
            synchronized (lock)
            {
                if(accounts[from] <amount){
                    return;
                }
                System.out.print(Thread.currentThread());

                accounts[from] -= amount;
                System.out.printf("%10.2f frm %d to %d", amount, from, to);
                accounts[to] += amount;

                System.out.printf("Total Balance: %10.2f %n", getTotalBalance());
            }

        }finally {
//            bankLock.unlock();
        }
    }

    public double getTotalBalance(){
        double sum=0;
        for(double a : accounts){
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }

    private Object lock = new Object();
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
}
