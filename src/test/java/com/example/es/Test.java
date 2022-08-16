package com.example.es;

public class Test {

    public double cal(double x1,double y1,double x2,double y2){

        x1 = x1*100000;
        x2 = x2*100000;

        y1 = y1*111320;
        y2 = y2*111320;

        double x = (x1 - x2)*(x1 - x2);
        double y = (y1 - y2)*(y1 - y2);
        return Math.sqrt(x + y);
    }

    @org.junit.Test
    public void test(){
        System.out.println(cal(104.061082,30.536089,104.065861,30.657401));
    }
}
