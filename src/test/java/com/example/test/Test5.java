package com.example.test;


import org.junit.Test;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

/**
 * @author: yangjie
 * @date: Created in 2019/11/19 13:32
 */

public class Test5 {

    @Test
    public void test() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("jps -l");
        BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String s = "";
        while ((line = bf.readLine()) != null){
            s = s + line + "\n";
        }
        System.out.println(s);
    }

    @Test
    public void test1(){
        String id = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println((int)(Math.random()*10000));
    }

    @Test
    public void test2(){
        boolean b = Objects.equals("1",1);
        boolean bb = Objects.equals("1000",1000);
        Integer c = 1000;
        int d = 1000;
        boolean bbb = Objects.equals(c,d);
        System.out.println(b);
        System.out.println(bb);
        System.out.println(bbb);
        System.out.println(c == 1000);
    }

    @Test
    public void test3() throws InterruptedException {

        while (true){
            Thread.sleep(500);
            t();
        }
    }

    public void t(){
        byte[] b = new byte[50*1024*1024];
        System.out.println(b);
    }

}
