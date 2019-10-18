package com.example.mainTest;

import com.example.vo.User;

import java.math.BigInteger;
import java.util.*;

/**
 * @description:
 * @author: yangjie
 * @date: Created in 2019/9/27 10:03
 */
public class Test2 {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        list.add(new User("1","2","3"));
        list.add(new User("1","2","3"));
        list.add(new User("1","2","3"));
        System.out.println(list);
        List<?> list_ = list;
        System.out.println(list_);


    }
}
