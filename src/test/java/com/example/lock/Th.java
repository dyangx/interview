package com.example.lock;

import com.example.vo.User;

import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class Th {

    public static void main(String[] args) throws InterruptedException {


        int i = 0;
        while (true){
            System.out.println(i);
            Thread.sleep(2000);
            i++;
            if(i == 100)
                break;
        }

        Vector<User> v = new Vector<>();
        v.remove(0);

        Future future;

        ThreadPoolExecutor threadPoolExecutor;
//        threadPoolExecutor.submit();
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1+1);

        CompletableFuture<Integer> completableFuture;
    }
}
