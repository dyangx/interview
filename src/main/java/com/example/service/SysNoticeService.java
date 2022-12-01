package com.example.service;

import com.example.domain.SysNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.Fan;
import com.example.vo.Page;

import java.util.List;

/**
* @author dyang
* @description 针对表【sys_notice(通知公告表)】的数据库操作Service
* @createDate 2022-09-21 15:55:16
*/
public interface SysNoticeService extends IService<SysNotice> {

    List<SysNotice> getList();

}
