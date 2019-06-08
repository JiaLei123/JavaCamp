package com.jialei.socketDemo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {
    public static void main(String[] args) {
        String urlName = "https://blog.csdn.net/wyg1997/article/details/80734142";
        try {
            URL url = new URL(urlName);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            Map<String, List<String>> headers = urlConnection.getHeaderFields();
            for(Map.Entry<String, List<String>> entry : headers.entrySet()){
                String key = entry.getKey();
                for(String value: entry.getValue()){
                    System.out.println(key + " : " + value);
                }
            }

            Scanner in = new Scanner(urlConnection.getInputStream());
//            for(int i =0; i < 10 ; i++){
//                System.out.println(in.nextLine());
//            }
            while (in.hasNext()){
                System.out.println(in.nextLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
