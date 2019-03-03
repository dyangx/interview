package com.example.aop.service.impl;

import com.example.aop.service.UserService;
import com.example.vo.User;
import org.springframework.stereotype.Service;

@Service("manService")
public class ManServiceImpl implements UserService {
    @Override
    public User printUser(User u) {
        System.out.println(u);
        return u;
    }

    @Override
    public User getUser(User u) {
        return null;
    }

}
