package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.aop.service.UserService;
//import com.example.feign.YhFeign;
import com.example.service.SpringContextUtil;
import com.example.utils.TestYouUtil;
import com.example.vo.ReqVO;
import com.example.vo.TestYouVO;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author: yangjie
 * @date: Created in 2020/2/21 15:14
 */
@RestController
public class TestYouController {

//    @Autowired
//    private YhFeign yhFeign;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @RequestMapping("/testYou")
    public Object testYou(String servieName,String methodName,String argClazz) throws ClassNotFoundException {

        Class x = Class.forName(argClazz);

        Object object = SpringContextUtil.getBean(servieName);
        User u = new User("1","张三","25");
        Method method = ReflectionUtils.findMethod(object.getClass(), methodName,x);

        Object c = (Object) u;
        Object o = ReflectionUtils.invokeMethod(method, object,c);
        return o;
    }

    @PostMapping("/testMe")
    public Object testMe(@RequestBody TestYouVO vo) throws ClassNotFoundException {
        ReqVO reqVO = TestYouUtil.handleReqParam(vo);
        Object bean = SpringContextUtil.getBean(vo.getServiceName());
        Method method = ReflectionUtils.findMethod(bean.getClass(), vo.getMethodName(),reqVO.getClasses());
        Object o = ReflectionUtils.invokeMethod(method, bean,reqVO.getArgs());
        return o;
    }

//    @GetMapping("testHer")
//    public Object testHer(){
//        JSONObject ob = new JSONObject();
//        ob.put("pageNum",10);
//        ob.put("pageSize",1);
//        String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2Jhc2VfaWQiOiIyNTk0MHwxNjUyOTI2Mzk0NDc3In0.0mLnhE67BgHWGuLMRhwEtzX6GzzNrsOjInmM9_AAQJoJTbdU9_L7uUbkEiV7R8UpSPwS3Mof6anr-QZa4bSdlg";
//        return yhFeign.go(ob,token);
//
//    }

}
