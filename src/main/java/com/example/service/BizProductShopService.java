package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.BizProductShop;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;

/**
* @author dyang
* @description 针对表【biz_product_shop】的数据库操作Service
* @createDate 2022-08-16 15:30:24
*/
public interface BizProductShopService extends IService<BizProductShop> {

    Object search(JSONObject json) throws IOException;

}
