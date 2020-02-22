package com.example.mainTest;

import com.example.service.TheadQueryService;
import com.example.utils.HttpRequestUtil;
import com.example.utils.TestYouUtil;
import com.example.vo.User;

/**
 * @author: yangjie
 * @date: Created in 2020/2/21 15:29
 */
public class Test6 {

    static TheadQueryService theadQueryService;

    public static void main(String[] args) {
        User u = new User();
        u.setAge("1");
        u.setId("000000");
        u.setName("张三");

        String s = TestYouUtil.postReq("userService","printUser", u);
        System.out.println(s);
    }



}
