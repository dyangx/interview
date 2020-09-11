package com.example.aop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @author: yangj
 * @date: Created in 2020/6/22
 */
public class Tester {

    public static void main(String[] args) {
        // jdk
        JDKProxy proxy = new JDKProxy(new TestServiceImpl());
        TestService service = (TestService) proxy.getInstance();
        service.say("李刚");
        //cglib
        TestService cgService  = (TestService) new CGLibProxy().getTarget(new TestServiceImpl());
        cgService.say("王刚");

        List<String> list = new ArrayList<>();
        List<String> s = list.stream().collect(Collectors.toList());

    }

    @Test
    public void test(){

        TestService testService = new TestServiceImpl();
        System.out.println(testService.getClass().getMethods()[0].getDeclaringClass());
        System.out.println(testService.getClass().getMethods()[1].getDeclaringClass());

        System.out.println(testService.getClass().getDeclaredMethods().length);
        Class o = testService.getClass().getDeclaredMethods()[0].getDeclaringClass();
        System.out.println(o);
    }

    public void test1(){

        ThreadPoolExecutor threadPoolExecutor;

    }
}
