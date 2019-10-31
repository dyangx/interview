package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.vo.Usr;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangjie
 * @date: Created in 2019/10/25 13:45
 */
public class Test2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Usr usr = new Usr("111","小明");
        Map<String,Object> map = new HashMap<>();
        map.put("gg",usr);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("uu",map);
        String jsonObject = JSONObject.toJSONString(map2);
        System.out.println(jsonObject);

        Object object = JSONObject.parseObject(new FileInputStream("C:\\Users\\Administrator\\Desktop\\bb.txt"),Object.class);
        System.out.println(object);
        System.out.println(object.toString());
        JSONObject j = JSONObject.parseObject(object.toString());
        System.out.println(j);
        System.out.println(j.getJSONObject("uu"));

    }
}
