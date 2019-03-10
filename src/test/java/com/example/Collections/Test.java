package com.example.Collections;

import java.io.InputStream;
import java.util.HashMap;
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
        IntStream.Builder bu = IntStream.builder();
        bu.add(1);
        bu.add(2);
        bu.build();
        System.out.println(bu);
    }
}
