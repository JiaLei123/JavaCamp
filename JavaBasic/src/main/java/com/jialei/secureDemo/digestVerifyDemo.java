package com.jialei.secureDemo;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.KeyGenerator;
import java.security.*;

public class digestVerifyDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String msg = "Hello World!";

        SecureRandom secrand = new SecureRandom();
        secrand.setSeed(111111L);
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(512, secrand);
        KeyPair key = keyGen.generateKeyPair();
        PublicKey publicKey = key.getPublic();
        PrivateKey privateKey = key.getPrivate();

        System.out.println("public key" + publicKey.toString());
        System.out.println("private key" + privateKey.toString());

        Signature signature = Signature.getInstance("DSA");
        signature.initSign(privateKey);
        signature.update(msg.getBytes());
        byte[] signatureMsg = signature.sign();

        System.out.println("原信息" + msg);
        System.out.println("加密信息" + Base64.encodeBase64URLSafeString(signatureMsg));

        Signature verifySignature = Signature.getInstance("DSA");
        verifySignature.initVerify(publicKey);
        verifySignature.update(signatureMsg);
        boolean check = verifySignature.verify(signatureMsg);

        System.out.println("验证结果" + check);
    }


}
