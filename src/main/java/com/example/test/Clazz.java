package com.example.test;

import org.apache.log4j.MDC;

import java.util.BitSet;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yangjie
 * @date: Created in 2019/10/22 17:55
 */
public class Clazz {

//    public Integer s1(List<String> list){
//        return 0;
//    }

    public String s1(List<Integer> list){
        Lock lock;
        ReentrantLock reentrantLock;
        BitSet bitSet;
        StringBuffer sb = new StringBuffer();
        return "";
    }

    public static void main(String[] args) throws InterruptedException {
        MDC.put("1","11");
        MDC.put("2","22");

        System.out.println(MDC.get("1"));
        System.out.println(MDC.get("2"));

        new Thread(()->{
            MDC.put("3","223");
            System.out.println(MDC.get("3"));
        }).start();

        Thread.sleep(1000);
        new Thread(()->{System.out.println(MDC.get("3"));}).start();
    }

}
