package com.example.controller;

import com.example.aop.service.UserService;
import com.example.service.SpringContextUtil;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author: yangjie
 * @date: Created in 2020/2/21 15:14
 */
@RestController
public class TestYouController {

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

}
