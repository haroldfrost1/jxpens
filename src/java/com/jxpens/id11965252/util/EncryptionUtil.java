/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jxpens.id11965252.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A utility class to handle secret encryption
 * @author harold
 */
public class EncryptionUtil {

    /**
     * Output a Hashed String encrypted with SHA256
     * @author https://gist.github.com/avilches/750151
     * @param data the password to be encrypted
     * @return the cipher
     * @throws NoSuchAlgorithmException 
     */
    public static String hash256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) {
            result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

}
