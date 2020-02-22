package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.HttpRequestUtil;
import com.example.vo.User;
import org.junit.Test;

public class Test7 {

    @Test
    public void test(){
        User u = new User();
        u.setAge("1");
        u.setId("000000");
        u.setName("张三");
        String s = JSON.toJSONString(u);
        System.out.println(s);
        String ss = HttpRequestUtil.sendPostReturnJsonStr("http://localhost:8080/hello/getfor",s,"jsonFormate");
        System.out.println(ss);
        System.out.println(u.getClass());
    }
}
