package com.example.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yangj
 * @date: Created in 2020/8/3
 */
public class AQSLock {

    private static ReentrantLock reentrantLock = new ReentrantLock();
    CountDownLatch countDownLatch;

    public void test(){
        reentrantLock.lock();
        reentrantLock.isLocked();

    }



}
