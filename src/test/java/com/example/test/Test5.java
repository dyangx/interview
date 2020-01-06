package com.example.test;


import org.junit.Test;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

/**
 * @author: yangjie
 * @date: Created in 2019/11/19 13:32
 */

public class Test5 {

    @Test
    public void test() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("jps -l");
        BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String s = "";
        while ((line = bf.readLine()) != null){
            s = s + line + "\n";
        }
        System.out.println(s);
    }

    @Test
    public void test1(){
        String id = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println((int)(Math.random()*10000));
    }

    @Test
    public void test2(){
        boolean b = Objects.equals("1",1);
        boolean bb = Objects.equals("1000",1000);
        Integer c = 1000;
        int d = 1000;
        boolean bbb = Objects.equals(c,d);
        System.out.println(b);
        System.out.println(bb);
        System.out.println(bbb);
        System.out.println(c == 1000);
    }

    @Test
    public void test3() throws InterruptedException {

        while (true){
            Thread.sleep(500);
            t();
        }
    }

    public void t(){
        byte[] b = new byte[50*1024*1024];
        System.out.println(b);
    }


    @Test
    public void test4(){
        String line = "  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态:-1-二级库待入库;0-一级库入库;1-一级库出库;2-二级库入库;3-领用;4-已使用;5-已计费;6-作废;7-退回;8-退货;9-移出;10-移入;11-退货暂存;12-调拨出库;13-调拨入库;14-移除;15-退费待审核;16-退费审核失败;17-已退费;18-最终使用;19-召回;70-禁止操作;20：计费已提报；21：已提交his计费申请；22：已退费提报；23：退费审核通过; 24：已提交his退费申请；25：已退费；26 已提交his取消计费申请 27：取消计费成功\\'',\n";
        System.out.println(line.indexOf(";") == -1 && line.indexOf("ENGINE") == -1);
        do{
            System.out.println(1);
        }while (true);
    }

    @Test
    public void test5(){
        int n = 16;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
    }

}
