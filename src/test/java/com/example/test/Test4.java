package com.example.test;

import com.example.vo.Usr;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2019/10/28 17:47
 */
public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("123456".substring(1));
        System.out.println("123456.xls".substring(0,"123456.xls".length() - 4));
    }

    @Test
    public void test() throws InterruptedException {

        int x = 0;
        while (x != 1000) {
            Object o = new Object();
            WeakReference<Object> softReference = new WeakReference(o);
            o = null;
            System.gc();
            Thread.sleep(200);
            System.out.print(softReference.get() == null);
            System.out.print("    ");
            System.out.println(softReference.isEnqueued());
            x++;
        }
    }

    @Test
    public void test1(){
        List<String> list = Arrays.asList("123","456","789");
        System.out.println(StringUtils.join(list,","));
    }

    @Test
    public void test2(){
        Usr usr = Usr.crate();
        Usr usr1 = Usr.crate();
        usr.setUsr(usr1);
        Usr usr2 = usr.getUsr();
        usr2.setId("13213213");
        System.out.println(usr);
    }

    @Test
    public void test3(){
        long s = System.currentTimeMillis() - 1000*60*60*24*5;
        String ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(s));
        System.out.println(ss);
    }

    @Test
    public void test4(){
        Usr u = new Usr().builder().age(1).birth(new Date()).name("dyxnrx").build();
        System.out.println(u);
    }
}
