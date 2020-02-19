package com.example.table;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2020/1/16 14:52
 */
public class Test2 {

    @Test
    public void test() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\sql\\hvc\\ispd-hvc.sql"));
        BufferedReader br = new BufferedReader(isr);
        FileWriter pw = new FileWriter("C:\\Users\\Administrator\\Desktop\\sql\\hvc\\ispd-hvc-r.sql");
        String str;
        while ((str = br.readLine()) != null){
            str = str.replaceAll("utf8 ","utf8mb4 ");
            str = str.replaceAll("utf8_general_ci ","utf8mb4_general_ci ");
            pw.write(str+"\n");
        }
        br.close();
        pw.flush();
        pw.close();
    }
}
