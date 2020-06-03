package com.example.utils;

import com.example.vo.Fo;

import java.util.ArrayList;
import java.util.List;

public class SortUtil {

    public static void main(String[] args) {
        List<Fo> list = new ArrayList<>();
        for(int i=0;i<50;i++){
            Fo fo = new Fo("",i%10-5);
            list.add(fo);
        }
        System.out.println(list);
        test(list);
        System.out.println(list);
    }

    public static void test(List<Fo> list){
        int first = 0;
        int mid = 0;
        int last = list.size() - 1;
        while(last > first){
            if(list.get(first).compareTo() < 0){
                mid = ++first;
            }else if(list.get(first).compareTo() == 0){
                if(list.get(last).compareTo() < 0){
                    swap(first,last,list);
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
    public static  <E> void swap(int a,int b,List<E> list){
        E e = list.get(a);
        list.set(a,list.get(b));
        list.set(b,e);
    }

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
