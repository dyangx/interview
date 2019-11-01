package com.example.test;

import com.example.vo.Usr;
import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author: yangjie
 * @date: Created in 2019/10/28 17:47
 */
public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("123456".substring(1));
        System.out.println("123456.xls".substring(0,"123456.xls".length() - 4));
    }

    @Test
    public void test() throws InterruptedException {

        int x = 0;
        while (x != 1000) {
            Object o = new Object();
            WeakReference<Object> softReference = new WeakReference(o);
            o = null;
            System.gc();
            Thread.sleep(200);
            System.out.print(softReference.get() == null);
            System.out.print("    ");
            System.out.println(softReference.isEnqueued());
            x++;
        }
    }
}
