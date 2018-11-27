package com.jialei;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int num = 3;
        try {
            while (!call_interface() && num < 5) {
                sleep(fum(num++)*1000);
            }
        }
        catch (Exception e){

        }

    }

    public static boolean call_interface(){
        System.out.println("call_interface");
        return false;
    }

    public static int fum(int num){
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return fum(num-2) + fum(num -1);
        }
    }
}
