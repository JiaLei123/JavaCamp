package com.jialei.socketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8189);
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (in.hasNext()){
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
