package com.example.aop.service.impl;

import com.example.aop.service.UserService;
import com.example.vo.User;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@EnableAspectJAutoProxy(exposeProxy = true)
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User printUser(User u) {
        System.out.println("printUser");
//        User user = ((UserServiceImpl) AopContext.currentProxy()).getUser(u);
        User user = this.getUser(u);
        return user;
    }

    public User getUser(User u) {
        System.out.println("getUser");
        return u;
    }
}
