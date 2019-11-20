package com.example.test;


import org.junit.Test;

import java.io.*;

/**
 * @author: yangjie
 * @date: Created in 2019/11/19 13:32
 */

public class Test5 {

    @Test
    public void test() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("jps -l");
        BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String s = "";
        while ((line = bf.readLine()) != null){
            s = s + line + "\n";
        }
        System.out.println(s);
    }


}
