package com.jialei;

import sun.util.calendar.BaseCalendar;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Class cl = BaseCalendar.Date.class;
        cl.getComponentType();
        System.out.println("Hello World");

        try {
            FileInputStream fin = new FileInputStream("abc.xml");
            DataInputStream din = new DataInputStream(new BufferedInputStream(fin));
            DataInputStream dzin = new DataInputStream(new ZipInputStream(fin));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
