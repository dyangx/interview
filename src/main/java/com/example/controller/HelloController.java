package com.example.controller;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.aop.service.UserService;
import com.example.service.TesetService;
import com.example.utils.ExcelUtil;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserService userService;
    @Value("${server.port}")
    private String port;

    @Autowired
    TesetService tesetService;


    @ResponseBody
    @RequestMapping("/user.json")
    public User user(){
        User u = new User("1","张三","25");
        return userService.printUser(u);
    }

    @ResponseBody
    @RequestMapping("/getPort.json")
    public String getPort(){
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
        String s1 = tesetService.insert() + "----";
        String s2 = tesetService.insertBatch(false)+ "----";
        String s3 = tesetService.insertBatch(true)+ "-----";
        String s4 = tesetService.insertBatchSession(false)+ "-----";
        String s5 = tesetService.insertBatchSession(true)+ "-----";
        String s6 = tesetService.insertBatchSessionF(false)+ "-----";
        String s7 = tesetService.insertBatchSessionF(true)+ "-----";
        return s1 + s2 + s3 + s4 + s5+s6+s7;
    }
}
