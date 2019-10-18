package com.example.test;

import com.example.InterviewApplication;
import com.example.aop.service.impl.SuperMan;
import com.example.vo.User;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import org.springframework.context.ApplicationContext;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;

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
        StringBuffer sb = new StringBuffer();
    }

    @Test
    public void test3(){

    }
    public String out(String x1){
        switch (x1){
            case "M":
                return "1";
            case "S" :
                return "2";
            case "T" :
                return "";
            default:
                return "no";
        }
    }

    @Test
    public void test4(){
        String s = new String("123456789");
        WeakReference wr = new WeakReference(s);
        s = null;
        System.out.println(wr.get());
        System.gc();
//        System.runFinalization();
        System.out.println(wr.get());
    }

    @Test
    public void test5(){
        String s = "q   weqrewtoopp";
        System.out.println(s.indexOf("oo"));
        StringBuffer sb = new StringBuffer("123456");
        int in = sb.indexOf("4");
        int inn = sb.indexOf("5");
        sb.delete(in,inn);
        System.out.println(sb.toString());
        System.out.println(in);
    }

    @Test
    public void te7(){
        LinkedHashSet<String> set = new LinkedHashSet<>(2000000);
        set.add("2");
        set.add("3");
        set.add("2");
        set.add("1");
        for (String s : set){
            System.out.println(s);;
        }
        System.out.println(set);
    }
}
