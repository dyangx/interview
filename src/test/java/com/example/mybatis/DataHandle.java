package com.example.mybatis;

import com.example.mybatis.vo.FieldVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataHandle {
    private static String url = "jdbc:mysql://rm-2vcg431j388xlt5541o.mysql.cn-chengdu.rds.aliyuncs.com:3306/nearby_travel?" +
            "serverTimezone=Asia/Shanghai";
    private static String user = "aliyun_test";
    private static String password = "testRootZby!2020@";

    public static void main(String[] args) throws SQLException {
        ResultSet rs = MySQL.tableFiledGen(url,user,password,"zycrm_business_opportunity_notice");
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
