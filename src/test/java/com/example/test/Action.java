package com.example.test;

import java.util.concurrent.*;

public class Action {

    public String doso() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.execute();
        executorService = new ThreadPoolExecutor(10, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        System.out.println(1);
        return "";
    }
}