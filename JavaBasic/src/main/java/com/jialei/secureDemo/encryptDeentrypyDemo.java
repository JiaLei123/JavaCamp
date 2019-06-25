package com.jialei.secureDemo;

import javax.crypto.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.*;

public class encryptDeentrypyDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES");

        SecureRandom secrand = new SecureRandom();
        secrand.setSeed(111111L);
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(secrand);
        SecretKey key = keyGen.generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);

    }

    public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws IOException, ShortBufferException, BadPaddingException, IllegalBlockSizeException {
        int blockSize = cipher.getBlockSize();//返回密码块大小
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes= new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;
        while (more){
            inLength = in.read(inBytes);
            if(inLength == blockSize){
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, inLength);
            } else {
                more = false;
            }
        }
        if(inLength > 0){
            outBytes = cipher.doFinal(inBytes, 0, inLength);
        }else {
            outBytes = cipher.doFinal();
        }
        out.write(outBytes);
    }
}
