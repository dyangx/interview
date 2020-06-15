package com.example.test;

import java.util.function.Function;

/**
 * @author: yangjie
 * @date: Created in 2020/6/8 16:59
 */
public class Test10 {

    public static void main(String[] args) {
        Function function = PassCo::say;
        System.out.println(function);
        function.apply("123456");

        int[] xx = new int['\uffff'];
        System.out.println(xx.length);
        System.out.println('\uffff');

    }
}
class PassCo{

    public static void say(){
        System.out.println("啊哈哈哈哈！");
    }

    public static Object say(Object o) {
        System.out.println("啊哈哈哈哈！"+o);
        return null;
    }
}
