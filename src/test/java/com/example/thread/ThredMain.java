package com.example.thread;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: yangjie
 * @date: Created in 2019/10/24 16:45
 */
public class ThredMain {

    public Integer i = 0;

    public static void test(String name){
        System.out.println(name + " start ....");
        if(name.contains("1")){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " end ....");
    }

    public static void add(){
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            test("t1");
        });
        Thread t2 = new Thread(() -> {
            test("t2");
        });
        Thread t3 = new Thread(() -> {
            test("t3");
        });

        t1.start();
        t2.start();
        t3.start();

        ReentrantLock lock = new ReentrantLock();
        ReentrantReadWriteLock lockj = new ReentrantReadWriteLock();
        lock.lock();

    }

}
