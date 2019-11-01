package com.example.controller;

import com.example.service.TheadQueryService;
import com.example.vo.Medical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author: yangjie
 * @date: Created in 2019/11/1 9:52
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired private TheadQueryService theadQueryService;

    @RequestMapping("/getAllMedical")
    public Map<String,Object> getAllMedical(){
        Map<String,Object> map = new HashMap<>();
        long s = System.currentTimeMillis();
        List<Medical> list = theadQueryService.normalQuery();
        long e = System.currentTimeMillis();
        map.put("time",(e-s)/1000.0);
        map.put("listSize",list.size());
        return map;
    }

    @RequestMapping("/getAllMedicalStep")
    public Map<String,Object> getAllMedicalStep() throws ExecutionException, InterruptedException {
        long s = System.currentTimeMillis();
        Map<String,Object> map = new HashMap<>();
        List<Medical> list = theadQueryService.StepQuery();
        long e = System.currentTimeMillis();
        map.put("time",(e-s)/1000.0);
        map.put("listSize",list.size());
        return map;
    }
}
