package com.example.test;

import com.example.service.FunctionService;
import com.example.vo.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: yangj
 * @date: Created in 2020/6/15
 */
public class Test11 {

    @Test
    public void test1(){
        this.getResult(x-> System.out.println(x+x),3);
        FunctionService functionService = (a, b) -> a+b;
        System.out.println(functionService.say(2,3));

    }

    public void getResult(Consumer<Integer> consumer,int val){
        consumer.accept(val);

    }

    @Test
    public void test2(){
        long s1 = System.currentTimeMillis();
        List<User> list = new ArrayList<>(10000000);
        for(int i=0;i<10000000;i++){
            User user = new User();
            user.setHeight(i);
            list.add(user);
        }
        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);

        list.stream().forEach(e -> {
            e.setId(new String(e.getAge()+1+""));
        });
        long s3 = System.currentTimeMillis();
        System.out.println(s3 - s2);
        list.parallelStream().forEach(e -> e.setName(new String(e.getAge() + 1 +"")));
        long s4 = System.currentTimeMillis();
        System.out.println(s4 -s3);


    }

    @Test
    public void test3(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
        System.out.println(list);

        Set<String> s = new HashSet<>();
        Set<String> sx = new TreeSet<>();

    }


}
