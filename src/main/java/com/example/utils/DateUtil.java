package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        Thread.sleep(1000);
        Date date2 = new Date();
        System.out.println(date2.compareTo(date));
    }

}
