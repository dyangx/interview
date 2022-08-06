package com.example.sildeWindow;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Test1 {


    @Test
    public void test1() throws InterruptedException {
        SlideWindowLimit limit = new SlideWindowLimit();
        int x = 0;
        while (true) {
            boolean b = limit.slideWindowLimit();
            if(b){
//                System.err.println("限流了 ");
            }else {
                System.out.println("没有限流 " +x +" "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                x++;
            }
        }
    }
}

class SlideWindowLimit {
    // 滑动窗口大小
    final int size = 10;
    // 滑动窗口数组，每移动一个格子，更新对应数据项的值
    int[] window = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    // 理解为移动窗口中正在计数的格子
    int curId = 0;
    // 记录上次统计时间
    Date lastDate = new Date();
    // 当前窗口计数总和
    int counter = 0;

    boolean slideWindowLimit() {
        // 获取当前时间
        Date now = new Date();
        // 当前时间同上次记录时间的间隔，单位为秒
        long time = (now.getTime() - lastDate.getTime()) / 1000;
        // 按照新的移动窗口进行计数
        if (time >= 1) {
            // 当前计数格子的下一个格子将被清掉重写
            int x = window[curId];
            counter = counter - x;
            curId++;
            curId = curId % size;
            // 下一个格子将被清掉，总数据减掉
            // 新格子设置为1
            window[curId] = 0;
            // 记录滑动的时间
            lastDate = now;
        }
        if(counter > 100) {
            return true;
        }
        if(window[curId] < 10){
            ++window[curId];
        }
        ++counter;
        return false;
    }

    boolean slideWindowLimit2() {
        // 获取当前时间
        Date now = new Date();
        // 当前时间同上次记录时间的间隔，单位为秒
        long time = (now.getTime() - lastDate.getTime()) / 1000;
        // 按照新的移动窗口进行计数
        if (time >= 1) {
            // 当前计数格子的下一个格子将被清掉重写
            curId++;
            curId = curId % size;
            int newCurId = curId;
            // 下一个格子将被清掉，总数据减掉
            counter = counter - window[newCurId];
            // 新格子设置为1
            window[newCurId] = 1;
            // 记录滑动的时间
            lastDate = now;
        } else {
            // 当前计数的格子
            ++window[curId];
        }
        ++counter;
        return counter >= 1000;
    }

    Entry[] arr = new Entry[10];
    int point = 0;
    boolean slideWindowLimit3() {
//        Date now = new Date();
//        // 当前时间同上次记录时间的间隔，单位为秒
//        long time = (now.getTime() - lastDate.getTime()) / 1000;
//        long now1 = now.getTime()/1000;
//        if (time >= 1) {
//            if(arr[point].get(now1)
//        }


        return false;
    }
}