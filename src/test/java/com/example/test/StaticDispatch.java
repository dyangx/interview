package com.example.test;

/**
 * @author: yangjie
 * @date: Created in 2019/11/28 14:03
 */
public class StaticDispatch {

    static class Human{
        public void sayhello(){
            System.out.println("1");
        }
    }

    static class Woman extends Human{
        @Override
        public void sayhello(){
            System.out.println("2");
        }
    }

    static class Man extends Human{
        public void sayhello(){
            System.out.println("3");
        }
    }

    public void sayHello(Human man){
        man.sayhello();
        System.out.println("hello,human!");
    }

    public void sayHello(Woman man){
        man.sayhello();
        System.out.println("hello,Woman!");
    }

    public void sayHello(Man man){
        man.sayhello();
        System.out.println("hello,Man!");
    }

    public static void main(String[] args) {
        Human woman = new Woman();
        Human man = new Man();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(woman);
        sd.sayHello(man);

        String s = "ss";
        Object o = s;
        Integer i = (Integer) o;

        int[] in = new int[-1];
    }
}
