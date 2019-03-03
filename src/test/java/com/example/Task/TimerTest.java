package com.example.Task;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTest {
    private static int i = 0;
    public static void main(String[] args) {
        /*TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(i++);
            }
        };
        //定义触发规则
        Timer timer = new Timer();
        // 大数
        long delay = 0;
        //秒
        long p = 1000;
        timer.scheduleAtFixedRate(timerTask,delay,p);*/

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = ()->{
            System.out.println(++i);
        };
        service.scheduleAtFixedRate(runnable,1,1, TimeUnit.SECONDS);
    }
}
