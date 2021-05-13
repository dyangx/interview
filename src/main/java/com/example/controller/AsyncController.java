package com.example.controller;

import com.example.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: yangjie
 * @date: Created in 2020/2/25 9:35
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/test")
    public String test(){
        long s = System.currentTimeMillis();
        asyncService.handle1(s);
        asyncService.handle2(s);
        long e = System.currentTimeMillis();
        return "complete:"+(e - s);
    }

    @RequestMapping("/test2/{id}")
    public String test2(@PathVariable("id") String id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        System.err.println(sdf.format(new Date()));
        long s = System.currentTimeMillis();
        String res = asyncService.test2(id);
        long e = System.currentTimeMillis();
        System.err.println(sdf.format(new Date()));
        return res + ("--> "+(e-s)/1000 + " s");
    }

    @RequestMapping("/test3/{id}")
    public String test3(@PathVariable("id") String id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        System.err.println(sdf.format(new Date()));
        long s = System.currentTimeMillis();
        String res = asyncService.test2(id);
        long e = System.currentTimeMillis();
        System.err.println(sdf.format(new Date()));
        return res + ("--> "+(e-s)/1000 + " s");
    }
}
