package com.example.mybatis;

import com.example.mybatis.vo.FieldVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataHandle {
    private static String url = "jdbc:mysql://152.136.190.118:33061/test?rewriteBatchedStatements=true&" +
            "useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2b8&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String password = "mysql88";

    public static void main(String[] args) throws SQLException {
        ResultSet rs = MySQL.tableFiledGen(url,user,password,"test3");
        List<FieldVO> list  = new ArrayList<>();
        while (rs.next()) { // 循环读取结果数据集中的所有记录
            list.add(new FieldVO(rs.getString("column_name"),rs.getString("column_comment"),
                    rs.getString("data_type")));
        }
        String s = StrUtil.handle(list);
        System.err.println("/***********************  start  ********************************/");
        System.out.println(s);
    }


}
