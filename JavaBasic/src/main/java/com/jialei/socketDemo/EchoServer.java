package com.jialei.socketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8189);
            System.out.println("Start a server");
            Socket incomming = s.accept();
            System.out.println("getSocket");
            Scanner in = new Scanner(incomming.getInputStream());
            PrintWriter out = new PrintWriter(incomming.getOutputStream(), true);
            out.write("HELLO Socket");
            boolean done = false;
            while (!done && in.hasNext()){
                String line = in.nextLine();
                System.out.println("getMessage:" + line);
                out.println("ECHO:" + line);
                if(line.trim().equals("BYE")){
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
