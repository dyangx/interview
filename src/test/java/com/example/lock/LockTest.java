package com.example.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yangjie
 * @date: Created in 2019/10/25 13:18
 */
public class LockTest {

    final static ReentrantLock lock = new ReentrantLock();

    public static void say(String s){
        final ReentrantLock lockk = lock;
        lockk.lock();
        try {
            System.out.println(s + "start..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s+"end...");
        } finally {
            lockk.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> say("t1"));
        Thread t2 = new Thread(() -> say("t2"));
        Thread t3 = new Thread(() -> say("t3"));
        t1.start();
        t2.start();
        t3.start();
    }
}
