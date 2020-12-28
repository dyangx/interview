package com.example.test;

public class Recode extends abstractRecode{

    @Override
    public void say() {
        super.say();
    }
}

abstract class abstractRecode{

    public void say(){
        this.hello();
    }
    private void hello(){
        System.out.println("hello");
    }
}