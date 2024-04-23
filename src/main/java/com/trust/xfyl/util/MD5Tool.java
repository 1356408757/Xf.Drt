package com.trust.xfyl.util;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
@Component
public class MD5Tool {

    /**
     * 生成了md5码
     *
     * @param plainText
     * @return
     */
    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    /**
     * 比对MD5值是否相同
     *
     * @param md51
     * @param md52
     * @return
     */
    public static boolean matchMD5(String md51, String md52) {
        return md51 != null && md51.equals(md52);
    }


   /* public static void main(String[] args) {
        String a = "123456s";
        String c = "123456s";
        String md5Str = DigestUtils.md5DigestAsHex(a.getBytes());
        String s = DigestUtils.md5DigestAsHex(c.getBytes());
        System.out.println(s);
        System.out.println(DigestUtils.md5DigestAsHex(md5Str.getBytes()));
        boolean b = MD5Tool.matchMD5(s, DigestUtils.md5DigestAsHex(md5Str.getBytes()));
        System.out.println(b);

    }*/
}
