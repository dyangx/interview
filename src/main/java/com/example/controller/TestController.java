package com.example.controller;

import com.example.utils.DateUtil;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/tt")
public class TestController {

    @Resource(name="reqExecutor")
    private ThreadPoolTaskExecutor reqExecutor;

    @RequestMapping("/test")
    public Object test() throws ExecutionException, InterruptedException {

        String s = "开始："+ DateUtil.format(new Date());
        System.out.println(s);
        Future<String> res1 = reqExecutor.submit(() -> {
            Thread.sleep(2000);
            return "1";
        });
        Future<String> res2 = reqExecutor.submit(() -> {
            Thread.sleep(2000);
            return "2";
        });
        Future<String> res3 = reqExecutor.submit(() -> {
            Thread.sleep(2000);
            return "3";
        });
        res1.get();
        System.out.println(DateUtil.format(new Date()));
        res2.get();
        System.out.println(DateUtil.format(new Date()));
        res3.get();
        System.out.println(DateUtil.format(new Date()));
        System.out.println(reqExecutor.getActiveCount());
        return DateUtil.format(new Date());
    }
}
