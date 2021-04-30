package com.example.mainTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:  zz
 *
 * @Author: yang jie
 * @Date: 2021/4/28 16:02
 */
public class Test9 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");

        int x = 1;
        x |= 3;
        System.out.println(x);

        JSONObject o = new JSONObject();
        o.put("k",list);

        List<String> types = o.getObject("k",List.class);
        System.out.println(JSON.toJSONString(types));

        List<String> types2 = o.getObject("k",new TypeReference<List<String>>(){});
        System.out.println(JSON.toJSONString(types2));

    }
}
class Cro{

    public void test(String s, Feature... l){
        Feature[] f = l;
        int x = f.length;
        System.out.println(x);

    }
}
