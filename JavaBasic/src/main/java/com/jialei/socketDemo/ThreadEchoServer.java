package com.jialei.socketDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadEchoServer {
    public static void main(String[] args) {
        int i = 1;
        try {
            ServerSocket s = new ServerSocket(8189);
            while (true){
                Socket incomming = s.accept();
                ThreadEchoHandle echoRunnable = new ThreadEchoHandle(incomming, i);
//                Thread thread = new Thread(echoRunnable);
//                thread.run();

                ExecutorService services = Executors.newFixedThreadPool(100);
                services.submit(echoRunnable);

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ThreadEchoHandle implements Runnable{
    private Socket incomming;
    private int count;
    public ThreadEchoHandle(Socket i, int c){
        this.incomming = i;
        this.count = c;
    }

    @Override
    public void run() {
        System.out.println("getSocket in Thread " + Thread.currentThread().getName());
        try {
            Scanner in = new Scanner(incomming.getInputStream());
            PrintWriter out = new PrintWriter(incomming.getOutputStream());
            out.println("HELLO My Socket\n");
            boolean done = false;
            while (!done && in.hasNext()) {
                String line = in.nextLine();
                System.out.println("getMessage:" + line);
                out.println("ECHO:" + line);
                if (line.trim().equals("BYE")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}