package com.example.controller;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.aop.service.UserService;
import com.example.utils.ExcelUtil;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ResponseBody
    @RequestMapping("/user.json")
    public User user(){
        User u = new User("1","张三","25");
        return userService.printUser(u);
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
}
