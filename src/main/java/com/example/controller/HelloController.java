package com.example.controller;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.aop.service.UserService;
import com.example.config.PropertiesBean;
import com.example.service.SpringContextUtil;
import com.example.service.SpringContextUtil;
import com.example.service.TesetService;
import com.example.utils.ExcelUtil;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    @Qualifier("userService")
    UserService userService;
    @Value("${server.port}")
    private String port;

    @Autowired
    TesetService tesetService;

    @Autowired
    PropertiesBean propertiesBean;

    @ResponseBody
    @RequestMapping("/user.json")
    public User user(){
        User u = new User("1","张三","25");
        return userService.printUser(u);
    }

    @ResponseBody
    @RequestMapping("/getPort.json")
    public String getPort() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(System.currentTimeMillis()/1000);
        return "Hello, I am is "+port;
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {

        User user = new User("1","2","3");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user);
        ExcelUtil.exportExcel(userList, "title", "sheetName", User.class,"ss.xls", response);
    }

    @RequestMapping("/export2")
    public void export2(HttpServletResponse response) throws IOException {
        User user = new User("1","2","3");
        Map<String,Object> map = JSONObject.parseObject(JSON.toJSONString(user));
        List<Map<String,Object>> userList = new ArrayList<>();
//        map.put("")
        userList.add(map);
//        ExcelUtil.exportExcel(userList,"ss.xls", response);
        ExcelUtil.exportExcel(userList,"ss.xls", response);
    }

    @ResponseBody
    @RequestMapping("/getuser")
    public Object getuser(){
        return tesetService.getUser();
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(){
        return tesetService.insert();
    }

    @ResponseBody
    @RequestMapping("/insertBatch")
    public Object insertBatch(){
        String s1 = tesetService.insert() + "----\n";
        String s2 = tesetService.insertBatch(false)+ "----insertBatch\n";
        String s3 = tesetService.insertBatch(true)+ "-----insertBatch\n";
        String s4 = tesetService.insertBatchSession(false)+ "-----insertBatchSession\n";
        String s5 = tesetService.insertBatchSession(true)+ "-----insertBatchSession\n";
        String s6 = tesetService.insertBatchSessionF(false)+ "-----insertBatchSessionF\n";
        String s7 = tesetService.insertBatchSessionF(true)+ "-----insertBatchSessionF\n";
        return s1 + s2 + s3 + s4 + s5+s6+s7;
    }

    @ResponseBody
    @RequestMapping("/getPropertiesBean")
    public Object getPropertiesBean(){
        Environment e = propertiesBean.getEnvironment();
        System.out.println(e);
        return e;
    }

    @ResponseBody
    @PostMapping(value = "/getfor",consumes="application/json")
    public Object getfor(@RequestBody User u){
//        JSONObject o = u.getO();
//        User user = o.toJavaObject(User.class);
        return u;
    }

    @ResponseBody
    @RequestMapping(value = "/insertTr")
    public Object insertTr(){
        tesetService.insertTran();
        return "ok!";
    }

    @ResponseBody
    @RequestMapping(value = "/select.json")
    public Object select(){
        return tesetService.selectTran();
    }

    @ResponseBody
    @RequestMapping("/test")
    public User test(){
        Object object = SpringContextUtil.getBean("userService");
        User u = new User("1","张三","25");
        Method method = ReflectionUtils.findMethod(object.getClass(), "printUser",User.class);
        Object o = ReflectionUtils.invokeMethod(method, object,u);
        User uu = (User) o;
        System.out.println(uu);
        return uu;
    }
}
