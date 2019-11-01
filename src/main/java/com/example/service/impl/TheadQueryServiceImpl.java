package com.example.service.impl;

import com.example.mapper.TheadQueryMapper;
import com.example.service.TheadQueryService;
import com.example.utils.ThreadPool;
import com.example.vo.Medical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * @author: yangjie
 * @date: Created in 2019/11/1 9:25
 */
@Service
public class TheadQueryServiceImpl implements TheadQueryService {

    @Autowired TheadQueryMapper theadQueryMapper;

    @Override
    public List<Medical> normalQuery() {
        long start = System.currentTimeMillis();
        List<Medical> list = theadQueryMapper.normalQuery();
        long end = System.currentTimeMillis();
        System.out.print(start);
        System.out.print("     ");
        System.out.println((end - start)/1000.00);
        return list;
    }

    @Override
    public List<Medical> StepQuery() throws ExecutionException, InterruptedException {
        String s1 = "2019-10-10 10:10:10";
        String e1 = "2019-10-29 10:34:51";
        String s2 = e1;
        String e2 = "2019-11-10 10:10:10";
        ExecutorService executorService = ThreadPool.getThreadPool();
        List<Medical> res = new ArrayList<>();
        List<FutureTask<List<Medical>>> list = new ArrayList<>();
        FutureTask task1 = new FutureTask<>(new MyTask(s1,e1));
        list.add(task1);
        executorService.submit(task1);
        FutureTask task2 = new FutureTask<>(new MyTask(s2,e2));
        list.add(task2);
        executorService.submit(task2);
        for(FutureTask<List<Medical>> task : list){
            res.addAll(task.get());
        }
        return res;
    }


    class MyTask implements Callable<List<Medical>> {
        private String s;
        private String e;
        private MyTask(){};
        public MyTask(String s, String e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public List<Medical> call() throws Exception {
            long start = System.currentTimeMillis();
            List<Medical> list = theadQueryMapper.stepQuery(s,e);
            long end = System.currentTimeMillis();
            System.out.print(start);
            System.out.print("     ");
            System.out.println((end - start)/1000.00);
            return list;
        }
    }
}
