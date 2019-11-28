package com.example.junit;

import com.example.mapper.TableMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yangjie
 * @date: Created in 2019/11/26 15:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private TableMapper tableMapper;

    @org.junit.Test
    public void test() throws Exception {
        List<String> after = new ArrayList<>();
        List<String> no = new ArrayList<>();
        List<String> tables = getTables();
        PrintWriter pw = new PrintWriter("C:\\Users\\Administrator\\Desktop\\高职.sql");
        for(String name : tables){
            try {
                Map<String,String> map = tableMapper.getTableSql(name);
                String tableSql = map.get("Create Table");
                tableSql = tableSql.replaceAll("utf8 ","utf8mb4 ");
                tableSql = tableSql.replaceAll("utf8_general_ci ","utf8mb4_general_ci ");
                tableSql = "DROP TABLE IF EXISTS `"+name+"`;\n"+tableSql+";\n\n";
                if(tableSql.indexOf("FOREIGN KEY") > -1){
                    after.add(tableSql);
                    continue;
                }
                pw.write(tableSql);
            } catch (Exception e) {
                no.add(name);
            }
        }
        for (String q : after){
            pw.write(q);
        }
        pw.close();
        System.err.println("没有的表：");
        System.err.println(no);
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
