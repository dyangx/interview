//package com.example.feign;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@FeignClient("http://debug.lianlianlvyou.com/")
//public interface YhFeign {
//
//    @RequestMapping(value = "yhcrm/index.html#/contract/ContractQuery",method = RequestMethod.POST)
//    JSONObject go(@RequestBody JSONObject json,@RequestHeader("authorization") String token);
//}
