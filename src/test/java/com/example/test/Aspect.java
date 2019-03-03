package com.example.test;

import com.example.InterviewApplication;
import com.example.aop.service.UserService;
import com.example.aop.service.impl.SuperMan;
import com.example.aop.service.impl.UserServiceImpl;
import com.example.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

public class Aspect {

    @Test
    public void test1() {
        ApplicationContext app = SpringApplication.run(InterviewApplication.class);
//        userService = (UserService) app.getBean("userService");
//            userService = app.getBean("userService",UserService.class);
//            UserServiceImpl impl = app.getBean(UserServiceImpl.class);
            User u = new User("2","李四","25");
//            User user = impl.printUser(u);
            SuperMan sm = app.getBean(SuperMan.class);
            User user = sm.saveUser(u);
        System.out.println(user);
    }

    @Test
    public void test2() {
        ApplicationContext app = SpringApplication.run(InterviewApplication.class);
        User u = new User("2","李四","25");
        SuperMan sm = app.getBean(SuperMan.class);
        User user = sm.saveUser(u);
        System.out.println("the   end ..........");
    }
}
