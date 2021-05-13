package com.example.lock;

import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yangjie
 * @date: Created in 2019/10/25 13:18
 */
public class LockTest {

    static ReentrantLock lockk = new ReentrantLock();

    private static void say(String s){
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

        LockSupport lockSupport;
        Condition condition;
//        DefaultFuture defaultFuture;
        CopyOnWriteArrayList<String> coa = new CopyOnWriteArrayList<>();
        coa.add("1234");
        String s = coa.get(0);
        Vector<String> vector = new Vector<>();
        vector.add("123");
        vector.get(0);

        Executors.newCachedThreadPool();
//        new ThreadPoolExecutor();
    }
}
