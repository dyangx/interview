package com.example.service.impl;

import com.example.mapper.TestMapper;
import com.example.service.AsyncService;
import com.example.vo.Test3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yangjie
 * @date: Created in 2020/2/25 9:30
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    private TestMapper mapper;

    @Override
    public void handle1(long s) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep();
        long e = System.currentTimeMillis();
        System.out.println("------>start:"+s +"---->time:"+(e - s));
    }

    @Override
    public void handle2(long s) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        System.out.println("------>start:"+s +"---->time:"+(e - s));
    }

    @Override
    @Async
    public void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String test2(String id) {
        Test3 vo = mapper.selectById(id);
        System.out.println(vo);
        int x = mapper.updateById(vo.getId(),vo.getName(),"王mmmmm");
        System.out.println(x);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mapper.selectById(id).getName();
    }
}
