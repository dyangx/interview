package com.example.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yangjie
 * @date: Created in 2019/11/1 10:25
 */
public class ThreadPool {

    private ThreadPool(){}

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static ExecutorService getThreadPool(){
        return executorService;
    }

}
