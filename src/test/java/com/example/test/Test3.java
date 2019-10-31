package com.example.test;

import com.alibaba.fastjson.JSON;
import com.example.vo.Usr;
import org.junit.Test;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yangjie
 * @date: Created in 2019/10/25 15:37
 */
public class Test3 {

    @Test
    public void test2() throws InterruptedException {
        new Thread(() -> {
            int x = 0;
            while (true){
                System.out.println("Thread Name :   "+(x/10000.0) + "   万");
                x++;
            }

        }).start();
        Thread.sleep(100000);
    }


//    private static volatile Instrumentation instru = new Instrumentation();

    @Test
    public void test() throws InterruptedException {

        final AtomicInteger i = new AtomicInteger(1);
        List<Usr> list = new ArrayList<>(10000000);
        while (!i.toString().equals("50")){
            new Thread(() -> {
                int j =1;
                String name = i.toString();
                while (true){
                    try {
                        list.add(Usr.crate());
                        System.out.println("总共： "+i.toString()+" 个线程，这是第: "+name+" 个,第："+j+"次,list大小："
                                +(list.size()/10000.0)+" 万" + "占用空间： " + (JSON.toJSONString(list).getBytes().length)/(1048576.0)+" MB");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    j++;
                }
            }).start();
            Thread.sleep(10);
            i.addAndGet(1);
        }

        Thread.sleep(400000);
    }
}
class T extends Thread{
    public T(String name){
        this.name = name;
    }

    private String name;

    @Override
    public void run() {
        int j =1;
        while (true){
            try {
                System.out.println("总共： "+name+" 个线程，这是第: "+name+" 个,第："+j+"次");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            j++;
        }
    }
}
