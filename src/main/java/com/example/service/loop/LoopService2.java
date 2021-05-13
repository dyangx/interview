package com.example.service.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yangj
 * @date: Created in 2020/9/24
 */
@Component
public class LoopService2 {

    @Autowired
    private LoopService1 loopService1;

/*    @Autowired
    public LoopService2(LoopService1 loopService1){
        this.loopService1 = loopService1;
    }*/

    public void test(){
        loopService1.test();
        System.out.println("this is LoopService2");
    }

    public String say(){
        String thread = Thread.currentThread().getName();
        if(thread.contains("10")){
            throw new RuntimeException("eeeeerror");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread);
        return thread;
    }
}
