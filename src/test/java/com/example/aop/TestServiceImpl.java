package com.example.aop;

/**
 * @author: yangj
 * @date: Created in 2020/6/22
 */
public class TestServiceImpl implements TestService {
    @Override
    public void say(String name) {
        System.out.println("我是"+name);
    }
}
