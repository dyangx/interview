package com.example.service;

import java.util.function.Consumer;

/**
 * @author: yangj
 * @date: Created in 2020/6/15
 */
@FunctionalInterface
public interface FunctionService<T> {

    int say(int a,int b);
}

class FunctionServiceImpl<T> implements FunctionService{

    @Override
    public int say(int a, int b) {
        return a+b;
    }
}
