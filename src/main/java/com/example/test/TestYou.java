package com.example.test;

import com.example.service.TesetService;
import com.example.service.impl.TesetServiceImpl;
import com.example.vo.Usr;

import javax.swing.*;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @description:
 * @author: yangjie
 * @date: Created in 2019/8/28 17:05
 */
public class TestYou {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Thread t1 = new Thread(() ->{
            int i = 0;
            while (i != 10000){
                System.out.println("I am t1 in "+ i++);
                //                    Thread.sleep(1000);
            }
        });
        Thread t2 = new Thread(() ->{
            int i = 0;
            while (i != 10000){
                System.out.println("I am t2 in "+i++);
                //                    Thread.sleep(1000);
            }
        });

        t1.start();
        t2.start();
        Thread.yield();
        System.out.println("end........");

        final Exception e = new Exception();
//        e = new Exception();

    }
}
