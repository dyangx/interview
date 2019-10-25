package com.example.test;

import org.junit.Test;

/**
 * @author: yangjie
 * @date: Created in 2019/10/25 9:19
 */
public class Test1 {

    @Test
    public void test1(){

        Long s = 5l;
        Integer b = 126;
        System.out.println(s.equals(5));
        System.out.println(s == 5);
        System.out.println(b.equals(6));
        System.out.println(b == 126);
        System.out.println(b == (100 + 26));
    }
}
