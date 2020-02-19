package com.example.mainTest;

/**
 * @author: yangjie
 * @date: Created in 2019/11/21 14:32
 */
public class Test4 {

    private static final String HH = "hh";

    public static void main(String[] args) {
        String s = HH;
        String l = "hh";
        System.out.println(s);
        System.out.println(l);
        String ls = s + l;
        String lss = s + "hh";
        String lsss = HH + "hh";
        System.out.println(ls);
        System.out.println(lss);
        System.out.println(lsss);
    }
}
