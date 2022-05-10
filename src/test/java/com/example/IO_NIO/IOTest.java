package com.example.IO_NIO;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.vo.User;
import org.junit.Test;

import java.io.*;

public class IOTest {

    @Test
    public void test1() throws IOException {
//        FileInputStream f = new FileInputStream(new File("",""));
        FileInputStream fis  = new FileInputStream("C:\\Users\\DYANGX\\Desktop\\常用命令.txt");
        byte[] b = new byte[1024];
        int l = 0;
        while ((l = fis.read(b)) > 0){
            System.out.println(l);
            System.out.println(new String(b,"gbk"));
        }
        fis.close();
    }

    @Test
    public void test2() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\DYANGX\\Desktop\\常用命令.txt");
        char[] c = new char[1024];
        int l = 0;
        while ((l = fr.read(c)) > 0){
//            System.out.println(c);
            String s = new String(c);
            System.out.println(s);
        }
        fr.close();
    }

    @Test
    public void test3() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\DYANGX\\Desktop\\pro.sql");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt");
        byte[] b = new byte[1024];
        while (fis.read(b) > 0){
            fos.write(b);
            System.out.println(new String(b,"utf-8"));
        }
        fis.close();
        fos.close();
    }

    @Test
    public void test4() throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt",true);
        fw.write("你好呀，\n");
        fw.write("你好吧\n");
        fw.write("你好呢\n");
        fw.close();
    }

    @Test
    public void test5() throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt",true);
        PrintStream ps = new PrintStream(fos);
        ps.println("1234156789");
        ps.println(new User());
        ps.close();
    }

    @Test
    public void test6() throws IOException {
        PrintWriter pw = new PrintWriter("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt");
        pw.write("1234565");
        pw.close();
    }

    @Test
    public void test7() throws IOException {
        User user = new User("1","杰克","20");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt"));
        oos.writeObject(user);
        oos.close();
    }

    @Test
    public void test8() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt"));
        User u = (User)ois.readObject();
        System.out.println(u);
    }

    @Test
    public void test9() throws IOException {
//        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt"));
        PrintStream ps = new PrintStream(System.out);
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DYANGX\\Desktop\\常用命令.txt"));
        String s = "";
        while ((s = br.readLine()) != null){
            s = new String(s.getBytes("utf-8"),"utf-8");
            ps.println(s);
        }
        ps.close();
        br.close();
    }

//    @Test
public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = null;
    while ((s = br.readLine()) != null){
        System.out.println(s);
        if("0".equals(s)){
            System.exit(1);
        }
    }
}
    @Test
    public void test11() throws IOException{
        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt","rw");
        raf.seek(raf.length());
        System.out.println(raf.length());
        raf.write("添加内容\n".getBytes());
        raf.close();
    }

    @Test
    public void test12() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt", "rw");
        File file = File.createTempFile("temp",null);
        file.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(file);
        FileInputStream fis = new FileInputStream(file);
        int pos = 0;
        String read = null;
        while ((read = raf.readLine()) != null){
            read = new String(read.getBytes("ISO-8859-1"),"utf-8")+"\n";
            if(read.indexOf("端口") > -1){
                read = read.replaceAll("端口","口端端");
            }
            fos.write(read.getBytes());
        }
        byte[] b = new byte[64];
        raf.seek(0);
        while (fis.read(b) > 0){
            raf.write(b);
        }
        raf.close();
        fis.close();
        fos.close();
    }

    @Test
    public void test122() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\ll18\\Desktop\\tx.txt", "rw");
        String read = null;
        while ((read = raf.readLine()) != null){
            read = new String(read.getBytes("ISO-8859-1"),"utf-8")+"\n";
            System.out.println(read);
        }

    }

    @Test
    public void test13() throws IOException {
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt");
//        User u = new User("1","2","3");
//        String s = JSONObject.toJSONString(u);
//        System.out.println(s);
//        fos.write(s.getBytes());
//        fos.close();
        FileInputStream fis = new FileInputStream("C:\\Users\\DYANGX\\Desktop\\新建文本文档.txt");
        byte[] b= new byte[1024];
        fis.read(b);
        String s = new String(b);
        User uu = JSONObject.toJavaObject(JSON.parseObject(s),User.class);
        System.out.println(uu);
    }
}
