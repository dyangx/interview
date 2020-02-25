package com.example.table;

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
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Test {

    @Autowired
    private TableMapper tableMapper;

    /**
     * 筛选表
     * @author yangjie
     * @return
     */
    @org.junit.Test
    public void test() throws Exception {
        List<String> after = new ArrayList<>();
        List<String> no = new ArrayList<>();
        List<String> tables = getTables();
        PrintWriter pw = new PrintWriter("C:\\Users\\Administrator\\Desktop\\sql\\lvc\\lvc_table.sql");
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
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\sql\\lvc\\lvc.txt"));
        BufferedReader br = new BufferedReader(isr);
        List<String> list = new ArrayList<>();
        String tableName;
        while ((tableName = br.readLine()) != null){
            list.add(tableName);
        }
        br.close();
        return list;
    }

    @org.junit.Test
    public void test1() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\sql\\dizhi-qianyi.sql"));
        BufferedReader br = new BufferedReader(isr);
        List<String> tables = getTables();
        FileWriter pw = new FileWriter("C:\\Users\\Administrator\\Desktop\\sql\\lvc_table_all.sql",true);
        String sql;
        while ((sql = br.readLine())!= null){
            if(sql.startsWith("INSERT")){
                String table = sql.split("`")[1];
                if(tables.contains(table)){
                    pw.write(sql+"\n");
                    System.out.println(sql);
                }
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }

    /**
     * sql筛选 V2.0
     */
    @org.junit.Test
    public void test2() throws IOException {
        // 输入的sql
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\sql\\lvc\\ispd-hms0828.sql"));
        BufferedReader br = new BufferedReader(isr);
        // 输出sql
        FileWriter pw = new FileWriter("C:\\Users\\Administrator\\Desktop\\sql\\lvc\\lvc_table_data.sql",false);
        //包含的表
        List<String> containsTable = getTables();
        String line;
        String sql;
        while ((line = br.readLine()) != null){
            if(line.startsWith("INSERT") || line.startsWith("DROP")){
                String tName = line.split("`")[1];
                if(containsTable.contains(tName)){
                    sql = line + "\n";
                    pw.write(sql);
                }
            }else if(line.startsWith("CREATE TABLE")){
                String tName = line.split("`")[1];
                if(containsTable.contains(tName)){
                    sql = line + "\n";
                    do{
                        line = br.readLine();
                        sql = sql + line +"\n";
                        sql = sql.replaceAll("utf8 ","utf8mb4 ").replaceAll("utf8_general_ci ","utf8mb4_general_ci ");
                    }while (line.indexOf(";") == -1 || line.indexOf("ENGINE") == -1);
                    pw.write(sql);
                    pw.write("\n");
                }
            }
        }
        br.close();
        pw.close();
    }

    @org.junit.Test
    public void dropTable() throws IOException {
        // 保留的表
        List<String> containsTable = this.getTables();
        // 获取全部的表
        List<String> allTable = tableMapper.getAllTableName();
        // 删除出错的表
        List<String> list = new ArrayList<>();
        for (String t : allTable){
            if(!containsTable.contains(t)){
                try {
                    tableMapper.dropTable(t);
                }catch (Exception e){
                    e.printStackTrace();
                    list.add(t);
                }
            }
        }
        System.err.println("erro :->>>>");
        System.err.println(list);
    }
}
