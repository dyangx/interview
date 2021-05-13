package com.example.mybatis;

import java.sql.*;

public class MySQL {
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;


    public static ResultSet tableFiledGen(String url,String user,String pwd,String table){
        String sql = "select column_name,column_comment,data_type from information_schema.columns where table_name='"+table+"'";
        return querySql(url,user,pwd,sql);
    }
    public static ResultSet querySql(String url,String user,String pwd,String sql) {
        // 查询语句
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            stmt = conn.createStatement(); // 创建执行环境
            // 读取数据
            rs = stmt.executeQuery(sql); // 执行查询语句，返回结果数据集
//            rs.last(); // 将光标移到结果数据集的最后一行，用来下面查询共有多少行记录
//            System.out.println("共有" + rs.getRow() + "行记录：");
//            rs.beforeFirst(); // 将光标移到结果数据集的开头
            /*while (rs.next()) { // 循环读取结果数据集中的所有记录
                list.add(new VVO(rs.getString("column_name"),rs.getString("column_comment"),
                        rs.getString("data_type")));
            }*/
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动异常");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库异常");
            e.printStackTrace();
        } finally {
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                    if (rs != null)
                        rs.close(); // 关闭结果数据集
                    if (stmt != null)
                        stmt.close(); // 关闭执行环境
                    if (conn != null)
                        conn.close(); // 关闭数据库连接
                } catch (SQLException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        return rs;
    }
}
