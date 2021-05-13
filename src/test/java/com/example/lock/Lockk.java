package com.example.lock;

import java.util.concurrent.Semaphore;

public class Lockk {

    static final Semaphore semaphore = new Semaphore(2);

    static int i = 0;

    static void say(String name){
        System.out.println(name + "说： " + (++i));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static void go(String name){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            say(name);
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> go("t1"));
        Thread t2 = new Thread(() -> go("t2"));
        Thread t3 = new Thread(() -> go("t3"));
        t1.start();
        t2.start();
        t3.start();
    }
}
