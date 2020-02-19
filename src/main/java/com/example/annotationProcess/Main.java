package com.example.annotationProcess;

import com.example.vo.Medical;

/**
 * @author: yangjie
 * @date: Created in 2019/10/23 14:39
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("success");
        Medical m = new Medical();
        System.out.println(m);
    }

    @Test(value = "method is test!")
    public static void test(){
    }
}
