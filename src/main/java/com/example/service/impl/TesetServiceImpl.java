package com.example.service.impl;

import com.example.mapper.TesterMapper;
import com.example.service.TesetService;
import com.example.vo.Usr;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: yangjie
 * @date: Created in 2019/10/18 13:33
 */

@Service
public class TesetServiceImpl implements TesetService {

    @Autowired
    private TesterMapper testerMapper;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public void syso() {
        System.out.println("hello");
    }

    @Override
    public List<Usr> getUser() {
        return testerMapper.getUser();
//        return null;
    }

    @Override
    public String insert() {
        long s = System.currentTimeMillis();
        for(int i=0;i<20;i++){
            String id = UUID.randomUUID().toString().replaceAll("-","");
            testerMapper.insertUsr(id,"MrYang"+i);
        }
        long end = System.currentTimeMillis();
        String time = String.valueOf(end - s);
        System.out.println(time);
        return time;
    }

    @Override
    public String insertBatch(boolean b) {
        long s = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(b);
        TesterMapper mapper = sqlSession.getMapper(TesterMapper.class);
        for(int i=0;i<20;i++){
            String id = UUID.randomUUID().toString().replaceAll("-","");
            mapper.insertUsr(id,"BBBBBB"+i);
//            if (i == 10) throw new RuntimeException();
        }
//        sqlSession.commit();
        sqlSession.flushStatements();
        sqlSession.close();
        long end = System.currentTimeMillis();
        String time = String.valueOf(end - s);
        System.out.println(time);
        return time;
    }

    @Override
    public String insertBatchSession(boolean b) {
        long s = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,b);
        TesterMapper mapper = sqlSession.getMapper(TesterMapper.class);
        for(int i=40;i<60;i++){
            String id = UUID.randomUUID().toString().replaceAll("-","");
            testerMapper.insertUsr(id,"AAAAAAA"+i);
//            mapper.insertUsr(id,"AAAAAAA"+i);
            if (i == 50) throw new RuntimeException();
        }
//        sqlSession.commit();
        sqlSession.flushStatements();
        sqlSession.close();
        long end = System.currentTimeMillis();
        String time = String.valueOf(end - s);
        System.out.println(time);
        return time;
    }
    @Override
    public String insertBatchSessionF(boolean b) {
        long s = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,b);
        TesterMapper mapper = sqlSession.getMapper(TesterMapper.class);
        List<Usr> list = new ArrayList<>();
        for(int i=50;i<70;i++){
            String id = UUID.randomUUID().toString().replaceAll("-","");
            list.add(new Usr(id,"dyangx"+i,i,1,new Date(),new Date(),"123456789"));
        }
        sqlSession.flushStatements();
        sqlSession.close();
        long end = System.currentTimeMillis();
        String time = String.valueOf(end - s);
        System.out.println(time);
        return time;
    }
}
