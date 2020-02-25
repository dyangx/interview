package com.example.controller;

import com.example.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
