package com.example.test;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: yangjie
 * @date: Created in 2019/9/9 13:36
 */
public class New {

    @Test
    public void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.stream().filter(x -> x>2).forEach(x -> System.out.println(x));

        Set<String> s = new HashSet<>();
        List<String> ss = new ArrayList<>(s);
        System.out.println(ss);
    }
}
