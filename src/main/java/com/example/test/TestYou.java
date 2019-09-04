package com.example.test;

import javax.swing.*;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @description:
 * @author: yangjie
 * @date: Created in 2019/8/28 17:05
 */
public class TestYou {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("4","4");
        map.put("3","3");
        map.put("2","1");
        map.put("1","1");
        map.put("0","0");
        Set<String> l = map.keySet();
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()){
            Map.Entry<String,String> entry= (Map.Entry<String, String>) i.next();
            System.out.println(entry.getValue());
        }
    }
    @NotNull
    public static String alert(@NotNull String s)
    {
        if(s == "1"){
            JOptionPane.showInputDialog("donggggggg");
        }
        return null;
    }
}
