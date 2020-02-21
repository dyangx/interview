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
        String s = TestYouUtil.getReq("userService","printUser", User.class);
        System.out.println(s);
    }

    public static void stst(Class x){
        System.out.println(x);
        System.out.println(x.getName());
    }

}
