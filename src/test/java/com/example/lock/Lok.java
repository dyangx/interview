package com.example.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class Lok {



    public static void main(String[] args) {
        ReadWriteLock readWriteLock;

        StampedLock stampedLock;

        Character character;

        Long ll= 100L;
        Long lll= 100L;
        Long ss= 1000L;
        Long sss= 1000L;
        System.out.println(ll == lll);
        System.out.println(ss == sss);

        Object p = new Object();
        p.equals("1");
        p.hashCode();
    }

}
