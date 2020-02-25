package com.example.interview;

import com.example.aop.service.UserService;
import com.example.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class InterviewApplicationTests {

    @Autowired UserService userService;

    @Test
    public void contextLoads() {
        User u = new User("1","张三","25");
        userService.printUser(u);
    }


}

