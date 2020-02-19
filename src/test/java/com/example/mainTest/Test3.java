package com.example.mainTest;

import com.example.vo.Usr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2019/11/15 17:16
 */
public class Test3 {
    public static void main(String[] args) {
        List<Usr> list = new ArrayList<>();
        List<Usr> list1 = new ArrayList<>();

        list.add(new Usr().builder().age(5).build());
        list.add(new Usr().builder().age(5).build());

        for(int i=0;i<2;i++){
            for(Usr u : list){
                u.setAge(i);
                list1.add(u);
            }
        }
        System.out.println(list1);
    }
}
