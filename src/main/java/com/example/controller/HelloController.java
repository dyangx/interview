package com.example.controller;

import com.example.aop.service.UserService;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/user.json")
    public User user(){
        User u = new User("1","张三","25");
        return userService.printUser(u);
    }
}
