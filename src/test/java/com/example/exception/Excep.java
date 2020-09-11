package com.example.exception;

/**
 * @author: yangj
 * @date: Created in 2020/8/6
 */
public class Excep {

    public int test(){

        int i = 0;

        try {
            throw new RuntimeException("a");
        }catch (Exception e){
            return i;
        }finally {
            return ++i;
        }
    }

    public int[] test2(){

        int[] x = new int[1];

        try {
            throw new RuntimeException("a");
        }catch (Exception e){
            return x;
        }finally {
            x[0] = 1;
        }


    }

    public static void main(String[] args) {
        Excep excep = new Excep();
        int x = excep.test();
        System.out.println(x);

        int[] xx = excep.test2();
        System.out.println(xx[0]);

    }

}
