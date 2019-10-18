package com.example.mainTest;

import java.sql.*;
import java.util.Random;
import java.util.UUID;

/**
 * @description:
 * @author: yangjie
 * @date: Created in 2019/9/27 9:53
 */
public class Test {
    private static String url = "jdbc:mysql://localhost:3306/tester?rewriteBatchedStatements=true&" +
            "useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2b8&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String password = "123456";
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstm =null;
        ResultSet rt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT into usr(id,name,age,birth,phone,oder) values(?,?,?,DATE_ADD(NOW(),INTERVAL - ? HOUR),?,?)";
            pstm = conn.prepareStatement(sql);
//            conn.setAutoCommit(false);
            Long startTime = System.currentTimeMillis();
            Random rand = new Random();
            int a,b,c,d;
            for (int i = 1; i <= 10; i++) {
                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                pstm.setString(1, uuid);
                pstm.setString(2, i+"dyangx");
                a = rand.nextInt(10);
                pstm.setInt(3, a);
                b = rand.nextInt(40000);
                pstm.setInt(4, b);
                pstm.setInt(6, i);
                c = rand.nextInt(10);
                d = rand.nextInt(10);
                pstm.setString(5, "188"+a+"88"+rand.nextInt(10)+c+"66"+d);
                pstm.addBatch();
            }
            pstm.executeBatch();
//            conn.commit();
            Long endTime = System.currentTimeMillis();
            System.out.println("OK,用时：" + (endTime - startTime)/1000 + "秒");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
