package com.example.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class User implements Serializable {

    @Excel(name = "id")
    private String id;

    @Excel(name = "name")
    private String name;

    @Excel(name = "age")
    private String age;

    @Excel(name = "eage")
    private String eage;

    public User() {
    }

    public User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getEage() {
        return eage;
    }

    public void setEage(String eage) {
        this.eage = eage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
