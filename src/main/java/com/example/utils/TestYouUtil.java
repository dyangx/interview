package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.vo.ReqVO;
import com.example.vo.TestYouVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2020/2/21 16:03
 */
public class TestYouUtil {

    private String port;

    private String entranceUrl;

    private static final String DEFULAT_IP = "127.0.0.1";

    private static String baseUrl = "http://127.0.0.1:8080/testMe";

    private void init(){
        port = port == null?"80":port;
        entranceUrl = entranceUrl == null?"testYou":entranceUrl;
        baseUrl = "http://"+DEFULAT_IP+":"+port+"/"+entranceUrl;
    }

    public static String postReq(String servieName,String methodName,Object... args){
        TestYouVO vo = new TestYouVO(servieName,methodName);
        if(args != null){
            vo.setArgs(Arrays.asList(args));
            List<String> types = new ArrayList<>();
            for(Object o : args){
                String type = o.getClass().getName();
                types.add(type);
            }
            vo.setArgsType(types);
        }
        String result = HttpRequestUtil.sendPostReturnJsonStr(baseUrl,JSON.toJSONString(vo),"jsonFormate");
        return result;
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

    public static ReqVO handleReqParam(TestYouVO vo) throws ClassNotFoundException {
        ReqVO reqVO = new ReqVO();
        if(vo.getArgsType() != null && vo.getArgs() != null){
            List<String> list = vo.getArgsType();
            Class[] classes = new Class[list.size()];
            List<Object> argsList = vo.getArgs();
            Object[] args = new Object[list.size()];
            for(int i=0;i<list.size();i++){
                classes[i] = Class.forName(list.get(i));
                String jsonString = JSON.toJSONString(argsList.get(i));
                Object arg = JSONObject.parseObject(jsonString,classes[i]);
                args[i] = arg;
            }
            reqVO.setArgs(args);
            reqVO.setClasses(classes);
        }
        return reqVO;
    }
}
