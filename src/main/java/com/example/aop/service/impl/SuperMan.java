package com.example.aop.service.impl;

import com.example.vo.User;
import org.springframework.stereotype.Component;

@Component
public class SuperMan {

    public User saveUser(User user){
        System.out.println("saveUser");
//        "123".substring(5);
        return user;
    }
}
