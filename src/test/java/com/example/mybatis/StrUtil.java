package com.example.mybatis;

import com.example.mybatis.vo.FieldVO;

import java.util.List;

public class StrUtil {

    static String handle(List<FieldVO> list){
        StringBuffer sb = new StringBuffer();
        for(FieldVO vo : list){
            sb.append("@ApiModelProperty(\"").append(vo.getDesc()).append(" \")").append("\n");
            sb.append("@TableField(\"").append(vo.getColumn()).append("\") \n");
            sb.append("private ").append(typeHandle(vo.getType()) + " ").append(strHandle(vo.getColumn())).append(";\n \n");
        }
        return sb.toString();
    }

    static String strHandle(String s){
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '_'){
                if((i + 1) < s.length() && s.charAt(i+1) != '_'){
                    sb.append(String.valueOf(s.charAt(i+1)).toUpperCase());
                    i++;
                }
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String typeHandle(String s){
        if(s.contains("char") || s.equals("text")){
            return "String";
        }else if(s.equals("int") || s.equals("bigint")){
            return "Long";
        }else if(s.equals("tinyint")){
            return "Integer";
        }else if(s.contains("date") || s.contains("timestamp")){
            return "Date";
        }else if(s.contains("decimal")){
            return "BigDecimal";
        }
        throw new IllegalArgumentException("类型: "+s+" 不支持，请添加");
    }
}
