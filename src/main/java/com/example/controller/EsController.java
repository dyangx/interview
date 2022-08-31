package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.service.BizProductShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/es")
public class EsController {
    @Autowired
    BizProductShopService bizProductShopService;


    @RequestMapping("search")
    public Object test(@RequestBody JSONObject json) throws IOException {
        return bizProductShopService.search(json);
    }
}
