package com.example.unsafe;


import org.apache.tomcat.jni.OS;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println( System.getProperties().getProperty("os.name"));
    }

    /**
     * 计算字符串内容字符长度
     * 一个中文相当于两个英文
     */
    public static int calcCharacterLength(String checkStr) throws UnsupportedEncodingException {
        if (null == checkStr || checkStr.length() == 0) {
            return 0;
        }
        String newString = new String(checkStr.getBytes("GB2312"), StandardCharsets.ISO_8859_1);
        return newString.length();
    }

}
