package com.example.service.impl;

import com.example.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: yangjie
 * @date: Created in 2020/2/25 9:30
 */
@Service
@Async
public class AsyncServiceImpl implements AsyncService {

    @Override
    public void handle1(long s) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep();
        long e = System.currentTimeMillis();
        System.out.println("------>start:"+s +"---->time:"+(e - s));
    }

    @Override
    public void handle2(long s) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        System.out.println("------>start:"+s +"---->time:"+(e - s));
    }

    @Async
    public void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
