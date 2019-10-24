package com.example.Collections;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    @org.junit.Test
    public void test1(){
        HashMap<String,String> map = new HashMap<>();
        map.put("1","11");
        map.put("2","22");
        map.forEach((obj,p) -> {
            System.out.println(obj);
            System.out.println(p);
        });
    }

    @org.junit.Test
    public void test2(){
        long s1 = System.currentTimeMillis();
        List<String> list = new ArrayList<>(1000000);
        for(int i=0;i<1000000;i++){
            String s = String.valueOf((int)(Math.random()*100000));
            list.add(s);
        }
        List<String> list1 = new ArrayList<>();
        long s2 = System.currentTimeMillis();
        list.forEach(e ->{
            if(e.indexOf("23") > -1){
                list1.add(e);
            }
        });
        long s3 = System.currentTimeMillis();
        List<String> list2 =null;
        list2 = list.stream().filter(e -> e.indexOf("23") >-1 ).collect(Collectors.toList());
        long s4 = System.currentTimeMillis();
        List<String> list3 = new ArrayList<>(100000);
        for (int i=0;i<list.size();i++){
            if(list.get(i).indexOf("23") > -1){
                list3.add(list.get(i));
            }
        }
        long s5 = System.currentTimeMillis();
        System.out.println("创建用时："+(s2 - s1));
        System.out.println("foreach用时："+(s3 - s2));
        System.out.println("stream用时：" +(s4 - s3));
        System.out.println("for用时：" + (s5 - s4));
    }

    @org.junit.Test
    public void test3() throws InterruptedException {
        Thread.sleep(100);

    }
}
