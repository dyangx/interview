package com.example.controller;


import com.example.service.BizProductShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/es")
public class EsController {
    @Autowired
    BizProductShopService bizProductShopService;


    @RequestMapping("search")
    public Object test(String key,int pageNo,int pageSize) throws IOException {
        return bizProductShopService.search(key,pageNo,pageSize);
    }
}
