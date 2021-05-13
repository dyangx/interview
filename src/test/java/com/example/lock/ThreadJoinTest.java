package com.example.lock;

/**
 * @author: yangj
 * @date: Created in 2020/8/4
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();

        for (int i=0;i<10;i++){
            ThreadDemo demo = new ThreadDemo(i,main);
            demo.start();
            main = demo;
        }

        System.out.println("complete");

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.get();
        threadLocal.set("s");

    }
}
class ThreadDemo extends Thread{
    private int i;
    private Thread main;
    public ThreadDemo(int i,Thread thread){
        this.i = i;
        this.main = thread;
    }

    @Override
    public void run() {
        try {
            main.join(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
