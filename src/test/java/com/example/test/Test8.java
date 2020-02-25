package com.example.test;

/**
 * @author: yangjie
 * @date: Created in 2020/2/25 9:58
 */
public class Test8 {
    public static void main(String[] args) throws InterruptedException {
        long s = System.currentTimeMillis();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        long e = System.currentTimeMillis();
        System.out.println( e -s);
    }
}
