package com.example.test;

public interface You {

    public default void test(){
        System.out.println(1);
    }
}
class Me implements You{
}
