package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.vo.Po;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: yangjie
 * @date: Created in 2019/12/19 9:11
 */
public class Test6 {

    @Test
    public void test(){
        Po p = new Po();
        p.setId("1");
        p.setName("xxx");
        List<Po> list = new ArrayList<>();
        list.add(p);
        List<com.example.utils.Po> list2 = new ArrayList<>();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        System.out.println(jsonArray);
        list2 = JSONArray.parseArray(jsonArray.toJSONString(),com.example.utils.Po.class);
        System.out.println(list);
        System.out.println(list2);

        System.out.println("#################################");
        Object lo = list;
        System.out.println(lo);
        JSONArray jsonArray1 = JSONArray.parseArray(JSON.toJSONString(lo));
        System.out.println(jsonArray1);
        list2 = JSONArray.parseArray(JSON.toJSONString(lo),com.example.utils.Po.class);
        System.out.println(list2);


    }

    @Test
    public void test1(){
        for(int i =0;i<10 ;i++){
            String s = UUID.randomUUID().toString().replaceAll("-","");
            System.out.println(s);
        }
    }
    @Test
    public void test2(){
        Integer i = new Integer(2000);
        Integer ii = new Integer(2000);
        Integer iii = 128;
        Integer iiii = 128;
        System.out.println(iiii == iii);
        System.out.println(i == iii);
        System.out.println(i.equals(ii));
        Long l = new Long(2);
        System.out.println(i.equals(l));

    }

    @Test
    public void test3(){
        String s = "\\\\sss"+"\\"+"asdf"+"\\"+"s";
        System.out.println(s);
    }

    @Test
    public void test4(){
        String s = StringUtils.appendIfMissing("123" , null ,"321");
//        StringUtil.
        System.out.println(s);
    }
}
