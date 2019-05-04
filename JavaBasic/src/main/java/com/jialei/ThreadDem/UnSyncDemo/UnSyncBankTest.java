package com.jialei.ThreadDem.UnSyncDemo;

import com.jialei.ThreadDem.MyRunnable;

public class UnSyncBankTest {
    public static void main(String[] args) {
        Bank b = new Bank( NACCOUNT, INITIAL_BALANCE);
        for(int i=0; i < NACCOUNT; i++){
            Runnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }

    }

    public static final int NACCOUNT = 100;
    public static final double INITIAL_BALANCE = 1000;
}
