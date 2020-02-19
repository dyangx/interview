package com.example.table;

import org.junit.Test;

import java.io.*;

/**
 * @author: yangjie
 * @date: Created in 2019/12/31 15:00
 */
public class TestSql {

    /**
     * table data 分离
     * @param
     * @author yangjie
     * @return
     */
    @Test
    public void test() throws IOException {

        String baseUrl = "C:\\Users\\Administrator\\Desktop\\sql\\tablesql\\bz-ispd1223.sql";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(baseUrl));
        String tableUrl = baseUrl.replaceAll("\\.sql","_table.sql");
        String dataUrl = baseUrl.replaceAll("\\.sql","_data.sql");
        BufferedReader br = new BufferedReader(isr);
        // table
        FileWriter pwt = new FileWriter(tableUrl);
        // data
        FileWriter pwd = new FileWriter(dataUrl);
        String s = "";
        String line;
        while ((line = br.readLine()) != null){
            if(line.startsWith("DROP TABLE")){
                pwt.write(line+"\n");
                continue;
            }
            if(line.startsWith("INSERT")){
                pwd.write(line+"\n");
                continue;
            }
            s = s+line+"\n";
            if(line.endsWith(";")){
                pwt.write(s);
                s = "";
            }
        }

        pwd.flush();
        pwt.flush();
        pwd.close();
        pwt.close();
        br.close();
    }
}
