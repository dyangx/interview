package com.example.test;

import com.alibaba.fastjson.JSON;
import com.example.vo.Fo;
import com.example.vo.Page;
import com.example.vo.User;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    @Test
    public void test4(){

        System.out.println((int) 'G');
        System.out.println((char) 71);
    }

    @Test
    public void test5(){
     /*   Fo fo2 = new Fo("李四",1);
        Fo fo1 = new Fo("张三",-1);
        Fo fo3 = new Fo("王五",0);*/
        List<Fo> list = new ArrayList<>();
        for(int i=0;i<50;i++){
            Fo fo = new Fo("",i%10-5);
            list.add(fo);
        }
        System.out.println(list);
        this.test(list);
        System.out.println(list);
    }

    public void test(List<Fo> list){
        int first = 0;
        int mid = 0;
        int last = list.size() - 1;
        while(last > first){
            if(list.get(first).compareTo() < 0){
                mid = ++first;
            }else if(list.get(first).compareTo() == 0){
                if(list.get(last).compareTo() < 0){
                    this.swap(first,last,list);
                    mid = ++first;
                }else if(list.get(last).compareTo() == 0) {
                    if(mid < last){
                        if(list.get(mid).compareTo() < 0){
                            swap(first,mid,list);
                            mid = ++first;
                        }else if(list.get(mid).compareTo() > 0){
                            swap(mid,last,list);
                            last--;
                        }else {
                            mid++;
                        }
                    }else {
                        break;
                    }
                }else {
                    last--;
                }
            } else {
                if(list.get(last).compareTo() > 0){
                    last--;
                }else if(list.get(last).compareTo() == 0){
                    swap(first,last,list);
                    last--;
                }else {
                    swap(first,last,list);
                    mid = ++first;
                }
            }
        }
    }
    public <E> void swap(int a,int b,List<E> list){
        E e = list.get(a);
        list.set(a,list.get(b));
        list.set(b,e);
    }

    @Test
    public void test11(){
        Fo fo2 = new Fo("李四",2);
        Fo fo1 = new Fo("张三",1);
        List<Fo> list = new ArrayList<>();
        list.add(fo2);
        list.add(fo1);
        System.out.println(list);
        swap(0,1,list);
        System.out.println(list);
    }
}
