package com.example.sunJDK;

import com.example.vo.User;
import com.example.vo.Usr;

public class JPS {

    volatile double n = 0;

    /**
     *  虚拟机进程监控
     *  jps -l  : 列出虚拟机进程
     *  jstat -gcutil 11000  : 查看gc使用情况
     */
    public static void main(String[] args) throws InterruptedException {
        Integer x = 0;
        while (true){
            Usr u = new Usr();
            u.builder().name("yangjie").age(x++).build();
            Thread.sleep(2000);
            System.out.print(u);
            byte[] b = new byte[1024*1024*50];
            System.out.println(b);
        }
    }
}
