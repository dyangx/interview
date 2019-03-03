package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Test extends Base{
    public static void main(String[] args) {
        new Test();
        VO v = new VO("a","b");
        System.out.println(JSONObject.toJSON(v));
        InputStream i = new ByteArrayInputStream(v);
    }

}

class Base{
    Base(){
        System.out.println("base");
    }
    transient String s = "";
}
class VO{
    private String a;
    private transient String b;

    public VO() {
    }

    public VO(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}