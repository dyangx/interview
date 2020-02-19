package com.example.junit;

import com.example.annotationProcess.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2019/11/26 16:04
 */
public class SqlTest {

    @Test
    public void test() throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\sql\\2.6.10_gaozhigui.sql"));
        BufferedReader br = new BufferedReader(isr);
        String s;
        List<String> list = getTables();
//        while ((s=br.readLine())!= null){
//            if(s.indexOf("DROP") && )
//        }

    }

    public List<String> getTables() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\sql\\tables.txt"));
        BufferedReader br = new BufferedReader(isr);
        List<String> list = new ArrayList<>();
        String tableName;
        while ((tableName = br.readLine()) != null){
            list.add(tableName);
        }
        br.close();
        return list;
    }

}
