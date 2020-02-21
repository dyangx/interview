package com.example.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: yangjie
 * @date: Created in 2020/2/21 16:03
 */
public class TestYouUtil {

    private String port;

    private String entranceUrl;

    private static final String DEFULAT_IP = "127.0.0.1";

    private static String baseUrl;

    private void init(){
        port = port == null?"80":port;
        entranceUrl = entranceUrl == null?"testYou":entranceUrl;
        baseUrl = "http://"+DEFULAT_IP+":"+port+"/"+entranceUrl;
    }

    public static String getReq(String servieName,String methodName,Class argClazz){
        String reqUrl = assembleGetReqUrl(servieName,methodName,argClazz);
        String result = HttpRequestUtil.httpRequestGet(reqUrl);
        return result;
    }

    private static String assembleGetReqUrl(String servieName,String methodName,Class argClazz){
        String clazz = argClazz.getName();
        StringBuffer sb = new StringBuffer("http://127.0.0.1:8080/testYou");
        sb.append("?servieName="+servieName)
                .append("&methodName="+methodName)
                .append("&argClazz="+clazz);
        return sb.toString();
    }
}
