package com.example.mainTest;

/**
 * @author: yangjie
 * @date: Created in 2019/12/3 9:32
 */
public class Test5 {

    public static void main(String[] args) throws InterruptedException {
        Test5 t5 = new Test5();
        TestLam testLam = () -> {
            t5.say();
        };
        testLam.say();
        System.out.println("end......");
    }

    private void say(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("seelp！");
    }
}

interface TestLam{
    void say();
}
