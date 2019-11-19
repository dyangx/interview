package com.example.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer height;

    @Excel(name = "id")
    private String id;

    @Excel(name = "name")
    private String name;

    @Excel(name = "age")
    private String age;

    @Excel(name = "eage")
    private String eage;

    private JSONObject o;

    public User() {
    }

    public User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", eage='" + eage + '\'' +
                '}';
    }
}
