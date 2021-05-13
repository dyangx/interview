package com.example.sunJDK;

public interface FoAbstract {

    void say();

    static FoAbstract say1(){
        return () ->{
            System.out.println("hhhhhhhhhh");
        };
    }

}
