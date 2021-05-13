package com.example.jdk8;

import com.example.vo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: yangj
 * @date: Created in 2020/7/6
 */
public class ForEachTest {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for(int i=0;i<10;i++){
            User user = new User();
            user.setName("骚鸡");
            user.setHeight(i);
            users.add(user);
        }
        users.forEach(print);
        users.forEach(System.out::println);

    }

    static Consumer<User> print = (vo) ->{
        vo.setHeight(vo.getHeight() + 1);
        System.out.println(vo);
    };


}
