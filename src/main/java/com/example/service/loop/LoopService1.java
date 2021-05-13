package com.example.service.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: yangj
 * @date: Created in 2020/9/24
 */
@Component
public class LoopService1 {

    @Autowired
    private LoopService2 loopService2;

    public void test(){
        System.out.println("this is LoopService1");
    }
}
