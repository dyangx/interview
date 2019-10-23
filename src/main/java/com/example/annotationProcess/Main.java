package com.example.annotationProcess;

/**
 * @author: yangjie
 * @date: Created in 2019/10/23 14:39
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("success");
        test();
    }

    @Test(value = "method is test!")
    public static void test(){
    }
}
