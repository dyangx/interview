package com.example.Enum;

/**
 * @author: yangj
 * @date: Created in 2020/8/10
 */
public interface CstInterface {

    void say();

    static CstInterface sayHell(){
        return () -> System.out.println("hhhhhhhh");
    }

    static CstInterface sayHellB(){
        return () -> System.out.println("bbbbbbbb");
    }
}
