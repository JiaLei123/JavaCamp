package com.jialei.secureDemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

public class digitalDemo {
    public static void main(String[] args) {
        try {
            String msg = "Hello World!";
            MessageDigest alg = MessageDigest.getInstance("MD5");
            alg.update(msg.getBytes());
            byte[] hash = alg.digest();
            System.out.println(Base64.encodeBase64URLSafeString(hash));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
