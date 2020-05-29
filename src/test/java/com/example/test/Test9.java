package com.example.test;

import com.alibaba.fastjson.JSON;
import com.example.vo.Page;
import com.example.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test9 {

    @Test
    public void test22() {
        System.out.println(new Integer(1) == new Integer(1));
        System.out.println(new Integer(1024) == new Integer(1024));
    }

    @Test
    public void test23() {
        Page page = new Page();
        Object o = (Object) page;
        String s = JSON.toJSONString(o);
        System.out.println(s);

    }

    @Test
    public void test() {
        User u = new User();
        u.setAge("1");
        u.setId("000000");
        u.setName("张三");
        String s = JSON.toJSONString(u);
        System.out.println(s.length());
        System.out.println(RamUsageEstimator.sizeOf(u));
        System.out.println(RamUsageEstimator.shallowSizeOf(u));
        System.out.println(RamUsageEstimator.humanSizeOf(u));

        byte[] b = new byte[1024*1024];
        String ss = JSON.toJSONString(b);
        System.err.println(ss.length());
        System.err.println(RamUsageEstimator.sizeOf(b));
        System.err.println(RamUsageEstimator.shallowSizeOf(b));
        System.err.println(RamUsageEstimator.humanSizeOf(b));
    }

    @Test
    public void test2() {
        Integer i = 1;
        int in = 1;

        Integer b = 100000;
        Integer c = new Integer(10000);
        Integer cc = new Integer(10000);
        int bb = 100000;
        System.out.println( i.equals(in));
        System.out.println(b == bb);
        System.out.println(c == cc);
        System.out.println(c.equals(null));
        System.out.println(new Integer(10000) > new Integer(10000));
        System.out.println(new Integer(10001) > new Integer(10000));

    }

    @Test
    public void test3() {
        int cap = 1;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int x = (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
        System.out.println(x);
    }

    @Test
    public void test4() {
        System.out.println(new Date());
        System.out.println(new Date(System.currentTimeMillis()-1000*60*60*2));
    }

    static String num = "0123456789";
    @Test
    public void test5() {
        String s = "3[a2[c]2[abc]3[cd]ef]";
        String end = last(s);
        System.out.println(end);
    }

    public String last(String s){
        while (s.contains("[")){
            StringBuffer sb = new StringBuffer(gen(s));
            s = sb.reverse().toString();
        }
        return s;
    }

    public String gen(String base){
        List<String> list = new ArrayList<>();
        int ca = -1;
        StringBuffer x = new StringBuffer();
        StringBuffer num = new StringBuffer();
        for(int i=base.length() -1;i>=0;i--){
            char a = base.charAt(i);
            if(']' == a){
                if(ca == -1){
                    addString(list,x.toString(),new StringBuffer("1"));
                    x = new StringBuffer();
                    num = new StringBuffer();
                }else {
                    x.append(a);
                }
                ca +=1;
            }else if('[' == a){
                ca -=1;
                if(ca != -1){
                    x.append(a);
                }
            }else if(isNum(a)){
                if(ca != -1 ){
                    x.append(a);
                    continue;
                }
                if(i!=0 && isNum(base.charAt(i-1))){
                    num.append(a);
                }else {
                    num.append(a);
                    addString(list,x.toString(),num);
                    ca = -1;
                    x = new StringBuffer();
                    num = new StringBuffer();
                }
            }else{
                x.append(a);
            }

        }

        StringBuffer sb = new StringBuffer();
        list.stream().forEach(e -> sb.append(e));
        if(StringUtils.isNotEmpty(x)){
            sb.append(x);
        }
        return sb.toString();
    }

    public void addString(List<String> list,String s,StringBuffer num){
        int index = Integer.valueOf(num.reverse().toString());
        for(int i=0;i<index;i++){
            list.add(s);
        }
    }

    public boolean isNum(char x){
        return num.contains(String.valueOf(x));
    }

}























