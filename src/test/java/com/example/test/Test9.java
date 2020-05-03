package com.example.test;

import com.alibaba.fastjson.JSON;
import com.example.vo.Page;
import com.example.vo.User;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

public class Test9 {

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
        System.out.println(new Integer(1) == new Integer(1));
        System.out.println(new Integer(1024) == new Integer(1024));
    }

    @Test
    public void test3() {
        Page page = new Page();
        Object o = (Object) page;
        String s = JSON.toJSONString(o);
        System.out.println(s);

    }
}
