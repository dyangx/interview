package com.example.mainTest;

import com.example.service.TheadQueryService;
import com.example.utils.HttpRequestUtil;
import com.example.utils.TestYouUtil;
import com.example.vo.User;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangjie
 * @date: Created in 2020/2/21 15:29
 */
public class Test6 {

    static TheadQueryService theadQueryService;

    public static void main(String[] args) {
        User u = new User("11","222","we");
        Map<String,Object> map = new HashMap<>();
        System.out.println(map);
        System.out.println("\033[1;93;45m" + "就是酱紫的"+"\033[m");
        System.out.println("\033[5m" + "就是酱紫的");
        System.out.println("\033[31m" + "就是酱紫的");
        System.out.println("\033[32m" + "就是酱紫的-------------");
        System.out.println("\033[33m" + "就是酱紫的");
        System.out.println("\033[34m" + "就是酱紫的");
        System.out.println("\033[35m" + "就是酱紫的");
        System.out.println("\033[36m" + "就是酱紫的ssdss");
        System.out.println("\033[37m" + "就是酱紫的");
        System.out.println("\033[38m" + "就是酱紫的");
        System.out.println("\033[39m" + "就是酱紫的");
        System.out.println("\033[0;32m" + "就是酱紫的");
        System.out.println("\033[0;5m" + "就是酱紫的\033[0m");
        System.out.println("\033[46m" + "就是酱紫的"+"\033[m");
        System.out.println("------------------------------");
        System.out.println("\033[0;30;42m color!!! \033[0m Hello \n");
        System.out.println("\033[0;30;40m color!!! \033[0m Hello \n");
        System.out.println("\033[0;30;41m color!!! \033[0m Hello \n");
        System.out.println("\033[0;30;42m color!!! \033[0m Hello \n");
        System.out.println("\033[0;30;43m color!!! \033[0m Hello \n");
        System.out.println("\033[0;30;44m color!!! \033[0m Hello \n");
        System.out.println("\033[0;30;45m color!!! \033[0m Hello \n");
        System.out.println("\033[0;30;46m color!!! \033[0m ");
        System.out.println("\033[0;30;47m color!!!\n");
    }



}
