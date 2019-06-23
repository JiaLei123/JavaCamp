package com.jialei.ClassLoaderDemo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestClassLoader {
    public static void main(String[] args) {

    }
}

class CryptoClassLoader extends ClassLoader{

    protected Class findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = null;
        Class cl = null;
        try{
            classBytes = loadClassBytes(name);
            cl =defineClass(name, classBytes, 0, classBytes.length);

        } catch(IOException ex){
            System.out.println("error");
        }
        return cl;
    }

    private byte[] loadClassBytes(String name) throws IOException {
        FileInputStream in = new FileInputStream(name);
        try{
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int ch;
            while ((ch=in.read() )!= -1){
                byte b = (byte)ch;
                buffer.write(b);
            }
            in.close();
            return buffer.toByteArray();
        }
        finally {
            in.close();
        }
    }
}
