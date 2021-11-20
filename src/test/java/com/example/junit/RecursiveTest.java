package com.example.junit;

import com.alibaba.fastjson.JSON;
import com.example.mapper.TesterMapper;
import com.example.vo.Recursive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2019/12/5 16:40
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RecursiveTest {

    @Autowired
    private TesterMapper testerMapper;

    @Test
    public void test(){
        List<Recursive> list = testerMapper.queryPeople(1);
        System.out.println(list);
        String s = JSON.toJSONString(list);
        System.out.println(s);
        System.out.println(JSON.parseArray(s));
    }

    @Test
    public void test2(){
        Date d = new Date(1630454400000L + 3600000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
    }

    @Test
    public void test3(){

    }
}
