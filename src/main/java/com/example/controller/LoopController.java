package com.example.controller;

import com.example.service.loop.LoopService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yangj
 * @date: Created in 2020/9/24
 */
@RestController
@RequestMapping("/loop")
public class LoopController {

    @Autowired
    private LoopService2 loopService2;

    @RequestMapping("/say")
    public Object say(){
        loopService2.test();
        return "okk!";
    }

    @RequestMapping("/tell")
    public Object tell(){
        return loopService2.say();
    }
}
