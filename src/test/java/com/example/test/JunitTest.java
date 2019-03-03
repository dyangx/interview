package com.example.test;

import com.example.InterviewApplication;
import com.example.aop.service.impl.SuperMan;
import com.example.vo.User;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import org.springframework.context.ApplicationContext;

public class JunitTest {

    @Test
    public void test(){
        ApplicationContext app = SpringApplication.run(InterviewApplication.class);
        User u = new User("2","李四","25");
        SuperMan sm = app.getBean(SuperMan.class);
        User user = sm.saveUser(u);
    }

    @Test
    public void test2(){
        Integer a = 888888888;
        sout(a);
        System.out.println(a);
    }

    public void sout(Integer a){
        a = 1;
        System.out.println(a);;
    }
}
