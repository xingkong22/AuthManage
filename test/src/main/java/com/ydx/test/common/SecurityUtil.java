package com.ydx.test.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    public static String md5(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] mg = md.digest(src.getBytes());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < mg.length; i++){
                int x = (int)mg[i]&0xff;
                x = x + 1;
                if (x < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(x));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(md5("ABC"));
    }


}
