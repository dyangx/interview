package com.example.Quest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class tEST<ff> {



    @Test
    public void t() throws UnsupportedEncodingException {

        System.out.println("技".getBytes().length);
        System.out.println("K".getBytes("GBK").length);
        System.out.println("w3".getBytes("utf8").length);
        String s = "人ABC们DEF";
        s = subString(s,9);
        System.out.println(s);
    }

    private String subString(String s,int n){
        if(n<0){
            throw new RuntimeException();
        }
        int nx = 0;
        String resString = "";
        for(int i=0;i<s.length();i++){
            String thisS = s.substring(i,i+1);
            int pSize = thisS.getBytes().length;
            nx += pSize;
            if(nx > n){
                break;
            }
            resString += thisS;
        }
        return resString;
    }

    @Test
    public void test(){
        int arr[] = Sort.createArray(10);
        System.out.println(Arrays.toString(arr));
        Sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        for (ff();true;ff()){

        }
    }
    public boolean ff(){
        return false;
    }

    abstract class A{
        abstract void te();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
